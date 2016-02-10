package com.company.home.mathparser.token.types;

public final class Mul extends BinaryOperator
{
  public Mul()
  {
    super("*");
  }

  @Override protected int getPriority()
  {
    return 3;
  }

  @Override public Value evaluate(final Value first, final Value second)
  {
    return new Value(first.getValue() * second.getValue());
  }
}
