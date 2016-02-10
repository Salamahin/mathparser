package com.company.home.mathparser.token;

import com.company.home.mathparser.token.producers.TokenProducer;

import java.util.Objects;
import java.util.Optional;

public class Token
{
  private final String value;
  private final String remainingExpression;
  private final Optional<TokenProducer> excludedProducer;

  private Token(final String value, final String remainingExpression, final Optional<TokenProducer> excludedProducer) {
    this.value = value;
    this.remainingExpression = remainingExpression;
    this.excludedProducer = excludedProducer;
  }

  private static String extractRemainingExpression(String expression, int tokenLastCharIndexInExpression)
  {
    return expression.substring(tokenLastCharIndexInExpression + 1, expression.length());
  }

  private static String extractValue(String expression, int tokenLastCharIndexInExpression)
  {
    return expression.substring(0, tokenLastCharIndexInExpression+1);
  }

  public Token(final String expression, final int tokenLastCharIndexInExpression)
  {
    this(
        extractValue(expression, tokenLastCharIndexInExpression),
        extractRemainingExpression(expression, tokenLastCharIndexInExpression),
        Optional.empty());
  }

  public Token(final String expression, final int tokenLastCharIndexInExpression, final TokenProducer excludedProducer)
  {
    this(
        extractValue(expression, tokenLastCharIndexInExpression),
        extractRemainingExpression(expression, tokenLastCharIndexInExpression),
        Optional.of(excludedProducer));
  }

  public String getValue()
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

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Token token=(Token) o;
    return Objects.equals(value, token.value) &&
        Objects.equals(remainingExpression, token.remainingExpression);
  }

  @Override public int hashCode()
  {
    return Objects.hash(value, remainingExpression);
  }
}
