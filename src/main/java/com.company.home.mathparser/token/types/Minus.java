package com.company.home.mathparser.token.types;

public final class Minus extends BinaryOperator
{
  public Minus()
  {
    super("-");
  }

  @Override protected int getPriority()
  {
    return 1;
  }

  @Override public Value evaluate(final Value first, final Value second)
  {
    return new Value(first.getValue() - second.getValue());
  }
}
