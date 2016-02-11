package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.TokenInformation;
import com.company.home.mathparser.token.types.*;

import java.util.Optional;

public class UnaryOperationTokenProducer implements TokenProducer
{
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
    return new TokenInformation(new UnaryMinus(), expression.substring(1), Optional.empty());
  }
}
