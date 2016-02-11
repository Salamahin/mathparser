package com.company.home.mathparser.token.types;

public final class Div extends BinaryOperator
{
  public Div()
  {
    super("/");
  }

  @Override protected int getPrecedence()
  {
    return 3;
  }


  @Override
  protected Value doEvaluate(final Value first, final Value second) {
    return new Value(first.getValue() / second.getValue());
  }

  @Override
  public final boolean isLeftAssociative() {
    return true;
  }
}
