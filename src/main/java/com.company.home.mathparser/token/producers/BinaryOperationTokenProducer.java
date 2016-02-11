package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.TokenInformation;
import com.company.home.mathparser.token.types.*;

import java.util.Optional;

public final class BinaryOperationTokenProducer implements TokenProducer
{
  private static class InstanceHolder {
    private static final TokenProducer INSTANCE = new BinaryOperationTokenProducer();
  }

  private BinaryOperationTokenProducer() {
  }

  public static TokenProducer getInstance() {
    return InstanceHolder.INSTANCE;
  }

  @Override public Optional<TokenInformation> tryProduceToken(final String expression)
  {
    switch (expression.charAt(0))
    {
      case '-':
        return getTokenInformation(expression, new Minus());
      case '+':
        return getTokenInformation(expression, new Plus());
      case '/':
        return getTokenInformation(expression, new Div());
      case '*':
        return getTokenInformation(expression, new Mul());
      case '^':
        return getTokenInformation(expression, new Pow());

      default:
        return Optional.empty();
    }
  }

  private Optional<TokenInformation> getTokenInformation(final String expression, final ExpressionToken<?> token)
  {
    return Optional.of(new TokenInformation(token, expression.substring(1), this));
  }
}
