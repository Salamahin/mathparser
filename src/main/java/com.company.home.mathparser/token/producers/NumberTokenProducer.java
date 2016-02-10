package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.Token;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberTokenProducer implements TokenProducer
{
  private static final Pattern pattern=Pattern.compile("^[+-]?[0-9]*\\.?[0-9]+");

  @Override public Optional<Token> tryProduceToken(final String expression)
  {
    final Matcher m=pattern.matcher(expression);
    if (!m.find())
      return Optional.empty();

    final String token=m.group(0);

    return Optional.of(new Token(expression, token.length() - 1, this));
  }
}
