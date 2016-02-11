package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.TokenInformation;
import com.company.home.mathparser.token.types.*;

import java.util.Optional;

public class UnaryOperationTokenProducer implements TokenProducer
{
  private static class InstanceHolder {
    private static final TokenProducer INSTANCE = new UnaryOperationTokenProducer();
  }

  private UnaryOperationTokenProducer() {
  }

  public static TokenProducer getInstance() {
    return InstanceHolder.INSTANCE;
  }

  @Override public Optional<TokenInformation> tryProduceToken(String expression)
  {
    switch (expression.charAt(0))
    {
      case '-':
        return Optional.of(getTokenInformation(expression));

      default:
        return Optional.empty();
    }
  }

  private TokenInformation getTokenInformation(String expression)
  {
    return new TokenInformation(new UnaryMinus(), expression.substring(1));
  }
}
