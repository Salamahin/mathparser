package com.company.home.mathparser.token.types;

public final class Div extends BinaryOperator
{
  public Div()
  {
    super("/");
  }

  @Override protected int getPriority()
  {
    return 2;
  }

  @Override public Value evaluate(final Value first, final Value second)
  {
    return new Value(first.getValue() / second.getValue());
  }
}
