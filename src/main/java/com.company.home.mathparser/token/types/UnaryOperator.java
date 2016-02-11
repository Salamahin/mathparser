package com.company.home.mathparser.token.types;

import java.util.List;
import java.util.Stack;

abstract class UnaryOperator extends Operator
{
  protected UnaryOperator(String value)
  {
    super(value);
  }

  @Override public final void organiseRPN(final List<ExpressionToken<?>> california, final Stack<ExpressionToken<?>> texas)
  {
    texas.push(this);
  }

  protected abstract Value doEvaluate(final Value value);

  @Override
  public void evaluate(final Stack<ExpressionToken<?>> stack) {
    final Value v = (Value) stack.pop();
    stack.push(doEvaluate(v));
  }
}
