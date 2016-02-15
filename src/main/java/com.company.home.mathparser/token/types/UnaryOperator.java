package com.company.home.mathparser.token.types;

import com.company.home.mathparser.token.NotEnoughOperands;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public abstract class UnaryOperator extends Operator
{
  protected UnaryOperator(final String value, final String remainingExpression, final Optional<Token<?>> prevToken)
  {
    super(value, remainingExpression, prevToken);
  }

  @Override public final void organiseRPN(final List<Token<?>> california, final Stack<Token<?>> texas)
  {
    texas.push(this);
  }

  protected abstract Value doEvaluate(final Value value);

  @Override
  public void evaluate(final Stack<Token<?>> stack) {
    if(stack.size() < 1)
      throw new NotEnoughOperands();

    final Value v = (Value) stack.pop();
    stack.push(doEvaluate(v));
  }
}
