package com.company.home.mathparser.token.types;

public final class Plus extends BinaryOperator
{
  public Plus()
  {
    super("+");
  }

  @Override protected int getPrecedence()
  {
    return 1;
  }

  @Override public Value evaluate(final Value first, final Value second)
  {
    return new Value(first.getValue() + second.getValue());
  }

  @Override
  public final boolean isLeftAssociative() {
    return true;
  }
}
