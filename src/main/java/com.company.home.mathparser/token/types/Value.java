package com.company.home.mathparser.token.types;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public final class Value extends Token<Double>
{
  public Value(double value, final String remainingExpression, final Optional<Token<?>> prevToken)
  {
    super(value, remainingExpression, prevToken);
  }

  Value(final double value) {
    super(value, "", Optional.empty());
  }

  @Override public String toString()
  {
    return String.valueOf(getValue());
  }

  @Override public final void organiseRPN(final List<Token<?>> california, final Stack<Token<?>> texas)
  {
    california.add(this);
  }
}
