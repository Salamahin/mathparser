package com.company.home.mathparser.token.types;

import com.company.home.mathparser.token.NotEnoughOperands;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public abstract class BinaryOperator extends Operator
{
  protected BinaryOperator(final String value, final String remainingExpression, final Optional<Token<?>> nextToken)
  {
    super(value, remainingExpression, nextToken);
  }

  @Override public final void organiseRPN(final List<Token<?>> california, final Stack<Token<?>> texas)
  {
    while (texas.size() != 0)
    {
      final Token<?> head=texas.peek();
      if (!isBinaryOperator(head))
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
    final Precedence p1=getPrecedence();
    final Precedence p2=operator.getPrecedence();
    final int compareResult = p1.compareTo(p2);

    return (isLeftAssociative() && compareResult >= 0) ||
            (!isLeftAssociative() && compareResult > 0);
  }

  protected abstract Value doEvaluate(final Value first, final Value second);

  @Override
  public final void evaluate(final Stack<Token<?>> stack) {
    if(stack.size() < 2)
      throw new NotEnoughOperands();

    final Value second = (Value) stack.pop();
    final Value first = (Value) stack.pop();
    stack.push(doEvaluate(first, second));
  }


  private boolean isBinaryOperator(final Token<?> t)
  {
    return t instanceof BinaryOperator;
  }

  protected abstract boolean isLeftAssociative();
}
