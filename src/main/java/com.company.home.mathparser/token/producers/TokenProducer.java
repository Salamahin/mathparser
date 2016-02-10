package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.Token;

import java.util.Optional;

public interface TokenProducer
{
  Optional<Token> tryProduceToken(final String expression);

}
