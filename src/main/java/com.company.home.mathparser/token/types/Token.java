package com.company.home.mathparser.token.types;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public abstract class Token<T>
{
  private final T value;
  private final String remainigExpression;
  private final Optional<Token<?>> previousToken;

  protected Token(
          final T value,
          final String remainigExpression,
          final Optional<Token<?>> previousToken
  ) {
    this.value=value;
    this.remainigExpression = remainigExpression;
    this.previousToken = previousToken;
  }

  public final T getValue()
  {
    return value;
  }

  public final String getRemainigExpression() {
    return remainigExpression;
  }

  public final Optional<Token<?>> getPreviousToken() {
    return previousToken;
  }

  public abstract void organiseRPN(final List<Token<?>> california, final Stack<Token<?>> texas);
}
