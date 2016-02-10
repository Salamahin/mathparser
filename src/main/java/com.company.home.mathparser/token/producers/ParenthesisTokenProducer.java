package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.TokenInformation;
import com.company.home.mathparser.token.types.*;

import java.util.Optional;

public final class ParenthesisTokenProducer implements TokenProducer
{
  @Override public Optional<TokenInformation> tryProduceToken(final String expression)
  {
    switch (expression.charAt(0))
    {
      case '(':
        return getTokenInformation(expression, new OpenParenthesis());
      case ')':
        return getTokenInformation(expression, new ClosedParenthesis());

      default:
        return Optional.empty();
    }
  }

  private Optional<TokenInformation> getTokenInformation(final String expression, final ExpressionToken<?> token)
  {
    return Optional.of(new TokenInformation(token, expression.substring(1), Optional.of(this)));
  }
}
