package com.company.home.mathparser.token.types;

import java.util.List;
import java.util.Stack;

public final class LeftParenthesis extends ExpressionToken<String>
{
  public LeftParenthesis()
  {
    super("(");
  }

  @Override public final void organiseRPN(final List<ExpressionToken<?>> california, final Stack<ExpressionToken<?>> texas)
  {
    texas.push(this);
  }

  @Override
  public String toString() {
    return "(";
  }
}
