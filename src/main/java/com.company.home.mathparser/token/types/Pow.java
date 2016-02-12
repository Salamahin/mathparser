package com.company.home.mathparser.token.types;

import java.util.Optional;

public class Pow extends BinaryOperator
{
  public Pow(final String remainingExpression, final Optional<Token<?>> prevToken)
  {
    super("^", remainingExpression, prevToken);
  }

  @Override protected int getPrecedence()
  {
    return 4;
  }

  @Override
  protected Value doEvaluate(final Value first, final Value second) {
    return new Value(Math.pow(first.getValue(), second.getValue()));
  }

  @Override
  public final boolean isLeftAssociative() {
    return false;
  }
}
