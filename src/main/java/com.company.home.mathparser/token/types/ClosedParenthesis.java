package com.company.home.mathparser.token.types;

public class ClosedParenthesis extends Operator
{
  public ClosedParenthesis()
  {
    super(")");
  }

  @Override protected int getPriority()
  {
    return 0;
  }
}
