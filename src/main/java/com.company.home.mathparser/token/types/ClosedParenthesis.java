package com.company.home.mathparser.token.types;

import com.company.home.mathparser.token.UnbalancedException;

import java.util.List;
import java.util.Stack;

public class ClosedParenthesis extends Operator
{
  public ClosedParenthesis()
  {
    super(")");
  }

  @Override protected int getPriority()
  {
    return 0;
  }

  @Override public final void organiseRPN(final List<ExpressionToken<?>> california, final Stack<ExpressionToken<?>> texas)
  {
    while (!texas.isEmpty()) {
      if(tokenIsInstanceOfOpenParentesis(texas.pop())) {
        final ExpressionToken<?> head = texas.pop();
        if(head != null && tokenIsIntanceOfOperator(head))
          california.add(head);

        return;
      }
    }
    throw new UnbalancedException();
  }

  private boolean tokenIsInstanceOfOpenParentesis(final ExpressionToken<?> token){
    return token instanceof OpenParenthesis;
  }

  private boolean tokenIsIntanceOfOperator(final ExpressionToken<?> token) {
    return token instanceof Operator;
  }
}
