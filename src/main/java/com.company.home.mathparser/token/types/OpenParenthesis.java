package com.company.home.mathparser.token.types;

import java.util.List;
import java.util.Stack;

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

  @Override public final void organiseRPN(final List<ExpressionToken<?>> california, final Stack<ExpressionToken<?>> texas)
  {
    texas.push(this);
  }
}
