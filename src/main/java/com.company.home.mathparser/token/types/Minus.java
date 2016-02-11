package com.company.home.mathparser.token.types;

public final class Minus extends BinaryOperator
{
  public Minus()
  {
    super("-");
  }

  @Override protected int getPrecedence()
  {
    return 1;
  }

  @Override public Value evaluate(final Value first, final Value second)
  {
    return new Value(first.getValue() - second.getValue());
  }

  @Override
  public final boolean isLeftAssociative() {
    return true;
  }
}
