package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.types.*;

import java.util.Optional;

public final class BinaryOperationTokenProducer implements TokenProducer
{
  @Override
  public Optional<Token<?>> tryProduceToken(final String expression, final Optional<Token<?>> prevToken)
  {
    final String remainingExpression = expression.substring(1);

    switch (expression.charAt(0))
    {
      case '-':
        return Optional.of(new Minus(remainingExpression, prevToken));
      case '+':
        return Optional.of(new Plus(remainingExpression, prevToken));
      case '/':
        return Optional.of(new Div(remainingExpression, prevToken));
      case '*':
        return Optional.of(new Mul(remainingExpression, prevToken));
      case '^':
        return Optional.of(new Pow(remainingExpression, prevToken));

      default:
        return Optional.empty();
    }
  }
}
