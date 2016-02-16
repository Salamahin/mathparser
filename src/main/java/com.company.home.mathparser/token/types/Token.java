package com.company.home.mathparser.token.types;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public abstract class Token<T>
{
  private final T value;
  private final String remainingExpression;
  private final Optional<Token<?>> previousToken;

  Token(
      final T value,
      final String remainingExpression,
      final Optional<Token<?>> previousToken
  ) {
    this.value=value;
    this.remainingExpression=remainingExpression;
    this.previousToken = previousToken;
  }

  public final T getValue()
  {
    return value;
  }

  public final String getRemainingExpression() {
    return remainingExpression;
  }

  public final Optional<Token<?>> getPreviousToken() {
    return previousToken;
  }

  public abstract void organiseRPN(final List<Token<?>> california, final Stack<Token<?>> texas);
}
