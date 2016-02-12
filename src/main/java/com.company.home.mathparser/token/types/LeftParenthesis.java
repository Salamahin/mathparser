package com.company.home.mathparser.token.types;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public final class LeftParenthesis extends Token<String>
{
  public LeftParenthesis(final String remainingExpression, final Optional<Token<?>> prevToken)
  {
    super("(", remainingExpression, prevToken);
  }

  @Override public final void organiseRPN(final List<Token<?>> california, final Stack<Token<?>> texas)
  {
    texas.push(this);
  }

  @Override
  public String toString() {
    return "(";
  }
}
