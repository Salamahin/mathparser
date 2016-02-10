package com.company.home.mathparser.token.types;

public final class OpenParenthesis extends Operator
{
  public OpenParenthesis()
  {
    super("(");
  }

  @Override protected int getPriority()
  {
    return 0;
  }
}
