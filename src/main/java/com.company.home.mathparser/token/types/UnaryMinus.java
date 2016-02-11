package com.company.home.mathparser.token.types;

public class UnaryMinus extends UnaryOperator
{
  public UnaryMinus()
  {
    super("un-");
  }


  @Override protected int getPrecedence()
  {
    return 1;
  }

  @Override
  protected Value doEvaluate(final Value value) {
    return new Value(-value.getValue());
  }
}
