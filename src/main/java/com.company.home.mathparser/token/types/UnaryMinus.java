package com.company.home.mathparser.token.types;

public class UnaryMinus extends UnaryOperator
{
  public UnaryMinus()
  {
    super("-");
  }

  @Override public Value evaluate(Value value)
  {
    return new Value(-value.getValue());
  }

  @Override protected int getPriority()
  {
    return 1;
  }
}
