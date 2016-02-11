package com.company.home.mathparser.token.types;

import java.util.List;
import java.util.Stack;

abstract class UnaryOperator extends Operator
{
  protected UnaryOperator(String value)
  {
    super(value);
  }

  public abstract Value evaluate(final Value value);

  @Override public final void organiseRPN(final List<ExpressionToken<?>> california, final Stack<ExpressionToken<?>> texas)
  {
    texas.push(this);
  }
}
