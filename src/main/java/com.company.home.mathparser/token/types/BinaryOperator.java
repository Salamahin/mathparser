package com.company.home.mathparser.token.types;

public abstract class BinaryOperator extends Operator
{
  protected BinaryOperator(String value)
  {
    super(value);
  }

  public abstract Value evaluate(final Value first, final Value second);
}
