package com.company.home.mathparser.token.types;

import java.util.List;
import java.util.Stack;

public final class Value extends ExpressionToken<Double>
{
  public Value(double value)
  {
    super(value);
  }

  @Override public String toString()
  {
    return String.valueOf(getValue());
  }

  @Override public final void organiseRPN(final List<ExpressionToken<?>> california, final Stack<ExpressionToken<?>> texas)
  {
    california.add(this);
  }
}
