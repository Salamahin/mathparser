package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.TokenInformation;
import com.company.home.mathparser.token.types.Value;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValueTokenProducer implements TokenProducer
{
  private static class InstanceHolder {
    private static final TokenProducer INSTANCE = new ValueTokenProducer();
  }

  private ValueTokenProducer() {
  }

  public static TokenProducer getInstance() {
    return InstanceHolder.INSTANCE;
  }

  private static final Pattern pattern=Pattern.compile("^[+-]?[0-9]*\\.?[0-9]+");

  @Override public Optional<TokenInformation> tryProduceToken(final String expression)
  {
    final Matcher m=pattern.matcher(expression);
    if (!m.find())
      return Optional.empty();

    return Optional.of(getTokenInfo(expression, m.group(0)));
  }

  private TokenInformation getTokenInfo(final String expression, final String matchedGroup)
  {
    return new TokenInformation(new Value(Double.valueOf(matchedGroup)), expression.substring(matchedGroup.length()), this, UnaryOperationTokenProducer.getInstance());
  }
}
