package com.company.home.mathparser.token;

import com.company.home.mathparser.token.producers.TokenProducer;
import com.company.home.mathparser.token.types.ExpressionToken;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TokenInformation
{
  private final ExpressionToken<?> value;
  private final String remainingExpression;
  private final List<TokenProducer> excludedProducers;

  public TokenInformation(final ExpressionToken<?> value, final String remainingExpression, TokenProducer... excludedProducers)
  {
    this.value=value;
    this.remainingExpression=remainingExpression;
    this.excludedProducers=ImmutableList.copyOf(excludedProducers);
  }

  public ExpressionToken<?> getTokenValue()
  {
    return value;
  }

  public String getRemainingExpression()
  {
    return remainingExpression;
  }

  public List<TokenProducer> getExcludedProducers()
  {
    return excludedProducers;
  }
}
