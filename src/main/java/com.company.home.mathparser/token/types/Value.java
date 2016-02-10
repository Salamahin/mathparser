package com.company.home.mathparser.token.types;

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
}
