package com.company.home.mathparser.token.types;

import java.util.Optional;

public class UnaryMinus extends UnaryOperator
{
  public UnaryMinus(final String remainingExpression, final Optional<Token<?>> prevToken)
  {
    super("un-", remainingExpression, prevToken);
  }


  @Override protected int getPrecedence()
  {
    return 1;
  }

  @Override
  protected Value doEvaluate(final Value value) {
    return new Value(-value.getValue());
  }
}
