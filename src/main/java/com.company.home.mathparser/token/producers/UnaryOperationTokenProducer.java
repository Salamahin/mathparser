package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.types.*;

import java.util.Optional;

public class UnaryOperationTokenProducer implements TokenProducer
{
  @Override public Optional<Token<?>> tryProduceToken(final String expression, final Optional<Token<?>> prevToken)
  {
    switch (expression.charAt(0))
    {
      case '-':
        return Optional.of(new UnaryMinus(expression.substring(1), prevToken));

      default:
        return Optional.empty();
    }
  }
}
