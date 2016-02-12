package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.types.Token;

import java.util.Optional;

public interface TokenProducer
{
  Optional<Token<?>> tryProduceToken(final String expression, final Optional<Token<?>> prevToken);
}
