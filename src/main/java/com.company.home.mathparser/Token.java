package com.company.home.mathparser;

import java.util.Objects;

class Token
{
  private final String value;
  private final String remainingExpression;
  private final TokenProducer producer;

  Token(final String expression, final int tokenLastCharIndexInExpression, final TokenProducer producer)
  {
    this.producer=producer;
    this.value=expression.substring(0, tokenLastCharIndexInExpression+1);
    this.remainingExpression=expression.substring(tokenLastCharIndexInExpression + 1, expression.length());
  }

  public String getValue()
  {
    return value;
  }

  public String getRemainingExpression()
  {
    return remainingExpression;
  }

  public TokenProducer getProducer()
  {
    return producer;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Token token=(Token) o;
    return Objects.equals(value, token.value) &&
        Objects.equals(remainingExpression, token.remainingExpression) &&
        Objects.equals(producer, token.producer);
  }

  @Override public int hashCode()
  {
    return Objects.hash(value, remainingExpression, producer);
  }
}
