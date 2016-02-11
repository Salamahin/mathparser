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
    ExpressionToken<?> head;
    while ((head=texas.pop()) != null)
    {
      if (!tokenIsInstanceOfOperator(head))
      {
        california.add(head);
        continue;
      }

      final Operator other=(Operator) head;
      if (getPriority() <= other.getPriority())
      {
        california.add(head);
        continue;
      }

      texas.push(this);
      break;
    }
  }

  private boolean tokenIsInstanceOfOperator(final ExpressionToken<?> t)
  {
    return t instanceof Operator;
  }
}
