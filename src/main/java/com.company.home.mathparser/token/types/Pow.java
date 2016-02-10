package com.company.home.mathparser.token.types;

public class Pow extends BinaryOperator
{
  public Pow()
  {
    super("^");
  }

  @Override protected int getPriority()
  {
    return 4;
  }

  @Override public Value evaluate(final Value first, final Value second)
  {
    return new Value(Math.pow(first.getValue(), second.getValue()));
  }
}
