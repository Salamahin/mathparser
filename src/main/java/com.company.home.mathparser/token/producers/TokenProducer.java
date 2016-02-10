package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.TokenInformation;

import java.util.Optional;

public interface TokenProducer
{
  Optional<TokenInformation> tryProduceToken(final String expression);
}
