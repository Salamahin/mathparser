package com.company.home.mathparser.token.types;

import com.company.home.mathparser.token.UnbalancedException;

import java.util.List;
import java.util.Stack;

public class RightParenthesis extends ExpressionToken<String>
{
  public RightParenthesis()
  {
    super(")");
  }

  @Override public final void organiseRPN(final List<ExpressionToken<?>> california, final Stack<ExpressionToken<?>> texas)
  {
    ExpressionToken<?> head = null;
    while (!texas.isEmpty()) {
      head = texas.peek();
      if(tokenIsInstanceOfOpenParenthesis(head))
          break;

      california.add(texas.pop());
    }

    if(!tokenIsInstanceOfOpenParenthesis(head))
      throw new UnbalancedException();

    texas.pop();

    if(texas.size() == 0)
      return;

    head = texas.peek();
    if(tokenIsInstanceOfUnaryOperator(head))
      california.add(texas.pop());
  }

  private boolean tokenIsInstanceOfOpenParenthesis(final ExpressionToken<?> token){
    return token instanceof LeftParenthesis;
  }

  private boolean tokenIsInstanceOfUnaryOperator(final ExpressionToken<?> token) {
    return token instanceof UnaryOperator;
  }

  @Override
  public String toString() {
    return ")";
  }
}
