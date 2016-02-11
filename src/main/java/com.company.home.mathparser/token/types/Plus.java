package com.company.home.mathparser.token.types;

public final class Plus extends BinaryOperator
{
  public Plus()
  {
    super("+");
  }

  @Override protected int getPrecedence()
  {
    return 2;
  }

  @Override
  protected Value doEvaluate(final Value first, final Value second) {
    return new Value(first.getValue() + second.getValue());
  }

  @Override
  public final boolean isLeftAssociative() {
    return true;
  }
}
