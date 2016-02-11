package com.company.home.mathparser.token.types;

import java.util.List;
import java.util.Stack;

public abstract class BinaryOperator extends Operator
{
  protected BinaryOperator(String value)
  {
    super(value);
  }

  public abstract Value evaluate(final Value first, final Value second);

  @Override public final void organiseRPN(final List<ExpressionToken<?>> california, final Stack<ExpressionToken<?>> texas)
  {
//    texas.push(this);

    while (texas.size() != 0)
    {
      final ExpressionToken<?> head=texas.peek();
      if (!tokenIsInstanceOfBinaryOperator(head))
        break;

      final BinaryOperator other=(BinaryOperator) head;
      if (compareWith(other))
        california.add(texas.pop());

      texas.push(this);
    }

  }

  private boolean compareWith(final BinaryOperator operator)
  {
    return getPriority() <= operator.getPriority();
  }

  private boolean tokenIsInstanceOfBinaryOperator(final ExpressionToken<?> t)
  {
    return t instanceof BinaryOperator;
  }
}
