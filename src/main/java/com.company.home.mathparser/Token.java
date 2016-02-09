package com.company.home.mathparser;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Token
{
  private final String value;
  private final String remainingExpression;

  protected Token(final String value, final String remainingExpression)
  {
    this.value=value;
    this.remainingExpression=remainingExpression;
  }


  static List<String> parse(String expression) {
    final List<String> tokens = new ArrayList<>();

    Optional<Token> lastToken;
    while ((lastToken = extractToken(expression)).isPresent())
    {
      final Token t = lastToken.get();
      expression=t.remainingExpression;
      tokens.add(t.value);
    }

    return ImmutableList.copyOf(tokens);
  }

  private static Optional<Token> extractToken(final String expression)
  {
    return Optional.empty()
        .flatMap(ignored -> NumberToken.extract(expression));
  }

  private static class NumberToken extends Token
  {
    private static final Pattern pattern=Pattern.compile("/^\\d*\\.?\\d*$/");

    protected NumberToken(String value, String remainingExpression)
    {
      super(value, remainingExpression);
    }

    public static Optional<Token> extract(final String expression) {
      final Matcher m = pattern.matcher(expression);
      if(!m.matches())
        return Optional.empty();

      final String token = m.group(0);
      final String remaining = expression.substring(token.length(), token.length()-1);

      return Optional.of(new NumberToken(token, remaining));
    }
  }
}
