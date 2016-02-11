package com.company.home.mathparser.token.types;

import java.util.List;
import java.util.Stack;

public abstract class BinaryOperator extends Operator
{
  protected BinaryOperator(final String value)
  {
    super(value);
  }

  @Override public final void organiseRPN(final List<ExpressionToken<?>> california, final Stack<ExpressionToken<?>> texas)
  {
    while (texas.size() != 0)
    {
      final ExpressionToken<?> head=texas.peek();
      if (!tokenIsInstanceOfBinaryOperator(head))
        break;

      final BinaryOperator castedHead=(BinaryOperator) head;
      if (!compareWith(castedHead))
        break;

      california.add(texas.pop());
    }
    texas.push(this);
  }

  private boolean compareWith(final BinaryOperator operator)
  {
    return (isLeftAssociative() && getPrecedence() <= operator.getPrecedence()) ||
            (!isLeftAssociative() && getPrecedence() <  operator.getPrecedence());
  }

  protected abstract Value doEvaluate(final Value first, final Value second);

  @Override
  public final void evaluate(final Stack<ExpressionToken<?>> stack) {
    final Value second = (Value) stack.pop();
    final Value first = (Value) stack.pop();
    stack.push(doEvaluate(first, second));
  }


  private boolean tokenIsInstanceOfBinaryOperator(final ExpressionToken<?> t)
  {
    return t instanceof BinaryOperator;
  }

  public abstract boolean isLeftAssociative();
}
