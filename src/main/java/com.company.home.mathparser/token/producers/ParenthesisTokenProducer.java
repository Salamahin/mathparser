package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.TokenInformation;
import com.company.home.mathparser.token.types.*;

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

  @Override public Optional<TokenInformation> tryProduceToken(final String expression)
  {
    switch (expression.charAt(0))
    {
      case '(':
        return Optional.of(new TokenInformation(new LeftParenthesis(), expression.substring(1), BinaryOperationTokenProducer.getInstance()));
      case ')':
        return Optional.of(new TokenInformation(new RightParenthesis(), expression.substring(1), ValueTokenProducer.getInstance(), UnaryOperationTokenProducer.getInstance()));

      default:
        return Optional.empty();
    }
  }
}
