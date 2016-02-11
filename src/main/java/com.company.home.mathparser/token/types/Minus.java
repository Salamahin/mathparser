package com.company.home.mathparser.token.types;

public final class Minus extends BinaryOperator
{
  public Minus()
  {
    super("-");
  }

  @Override protected int getPrecedence()
  {
    return 2;
  }

  @Override
  protected Value doEvaluate(final Value first, final Value second) {
    return new Value(first.getValue() - second.getValue());
  }

  @Override
  public final boolean isLeftAssociative() {
    return true;
  }
}
