package com.company.home.mathparser.token.types;

public final class Mul extends BinaryOperator
{
  public Mul()
  {
    super("*");
  }

  @Override protected int getPrecedence()
  {
    return 3;
  }

  @Override public Value evaluate(final Value first, final Value second)
  {
    return new Value(first.getValue() * second.getValue());
  }

  @Override
  public final boolean isLeftAssociative() {
    return true;
  }
}
