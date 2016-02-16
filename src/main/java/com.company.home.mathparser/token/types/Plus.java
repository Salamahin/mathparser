package com.company.home.mathparser.token.types;

import java.util.Optional;

public final class Plus extends BinaryOperator
{
  public Plus(final String remainingExpression, final Optional<Token<?>> prevToken)
  {
    super("+", remainingExpression, prevToken);
  }

  @Override protected Precendence getPrecedence()
  {
    return Precendence.NORMAL;
  }

  @Override
  protected Value doEvaluate(final Value first, final Value second) {
    return new Value(first.getValue() + second.getValue());
  }

  @Override
  public final boolean isLeftAssociative() {
    return true;
  }
}
