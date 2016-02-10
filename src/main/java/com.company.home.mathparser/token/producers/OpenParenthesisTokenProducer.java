package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.Token;

import java.util.Optional;

public class OpenParenthesisTokenProducer implements TokenProducer
{

  @Override public Optional<Token> tryProduceToken(String expression)
  {
    if(expression.charAt(0) == '(')
      return Optional.of(new Token(expression, 0));
    return Optional.empty();
  }
}
