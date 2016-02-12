package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.types.LeftParenthesis;
import com.company.home.mathparser.token.types.RightParenthesis;
import com.company.home.mathparser.token.types.Token;

import java.util.Optional;

public final class ParenthesisTokenProducer implements TokenProducer
{
  private static class InstanceHolder {
    private static final TokenProducer INSTANCE = new ParenthesisTokenProducer();
  }

  private ParenthesisTokenProducer() {
  }

  public static TokenProducer getInstance() {
    return InstanceHolder.INSTANCE;
  }

  @Override public Optional<Token<?>> tryProduceToken(final String expression, final Optional<Token<?>> prevToken)
  {
    String remainingExpression = expression.substring(1);
    switch (expression.charAt(0))
    {
      case '(':
        return Optional.of(new LeftParenthesis(remainingExpression, prevToken));
      case ')':
        return Optional.of(new RightParenthesis(remainingExpression, prevToken));

      default:
        return Optional.empty();
    }
  }
}
