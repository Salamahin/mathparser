package com.company.home.mathparser.token;

import com.company.home.mathparser.token.producers.TokenProducer;
import com.company.home.mathparser.token.types.ExpressionToken;

import java.util.Optional;

public class TokenInformation
{
  private final ExpressionToken<?> value;
  private final String remainingExpression;
  private final Optional<TokenProducer> excludedProducer;

  public TokenInformation(final ExpressionToken<?> value, final String remainingExpression, final Optional<TokenProducer> excludedProducer) {
    this.value = value;
    this.remainingExpression = remainingExpression;
    this.excludedProducer = excludedProducer;
  }

  public ExpressionToken<?> getTokenValue()
  {
    return value;
  }

  public String getRemainingExpression()
  {
    return remainingExpression;
  }

  public Optional<TokenProducer> getExcludedProducer()
  {
    return excludedProducer;
  }
}
