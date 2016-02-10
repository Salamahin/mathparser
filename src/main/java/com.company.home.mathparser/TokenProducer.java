package com.company.home.mathparser;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface TokenProducer
{
  Optional<Token> tryProduceToken(final String expression);

  class NumberTokenProducer implements TokenProducer
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

  class OperationTokenProducer implements TokenProducer {

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

  class OpenParenthesisTokenProducer implements TokenProducer {

    @Override public Optional<Token> tryProduceToken(String expression)
    {
      if(expression.charAt(0) == '(')
        return Optional.of(new Token(expression, 0));
      return Optional.empty();
    }
  }

  class ClosedParenthesisTokenProdicer implements TokenProducer {

    @Override public Optional<Token> tryProduceToken(String expression)
    {
      if(expression.charAt(0) == ')')
        return Optional.of(new Token(expression, 0));
      return Optional.empty();
    }
  }
}
