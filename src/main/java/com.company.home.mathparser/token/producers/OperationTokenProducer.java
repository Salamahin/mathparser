package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.Token;

import java.util.Optional;

public class OperationTokenProducer implements TokenProducer
{

  @Override public Optional<Token> tryProduceToken(final String expression)
  {
    switch (expression.charAt(0)) {
      case '-':
      case '+':
      case '/':
      case '*':
        return Optional.of(new Token(expression, 0, this));

      default:
        return Optional.empty();

    }
  }
}
