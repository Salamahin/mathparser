package com.company.home.mathparser.token.types;

import java.util.Optional;

public final class Div extends BinaryOperator
{
  public Div(final String remainingExpression, final Optional<Token<?>> prevToken)
  {
    super("/", remainingExpression, prevToken);
  }

  @Override protected int getPrecedence()
  {
    return 3;
  }


  @Override
  protected Value doEvaluate(final Value first, final Value second) {
    return new Value(first.getValue() / second.getValue());
  }

  @Override
  public final boolean isLeftAssociative() {
    return true;
  }
}
