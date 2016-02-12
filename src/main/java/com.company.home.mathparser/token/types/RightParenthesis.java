package com.company.home.mathparser.token.types;

import com.company.home.mathparser.token.UnbalancedException;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class RightParenthesis extends Token<String>
{
  public RightParenthesis(final String remainingExpression, final Optional<Token<?>> prevToken)
  {
    super(")", remainingExpression, prevToken);
  }

  @Override public final void organiseRPN(final List<Token<?>> california, final Stack<Token<?>> texas)
  {
    Token<?> head = null;
    while (!texas.isEmpty()) {
      head = texas.peek();
      if(tokenIsInstanceOfLeftParenthesis(head))
          break;

      california.add(texas.pop());
    }

    if(!tokenIsInstanceOfLeftParenthesis(head))
      throw new UnbalancedException();

    texas.pop();

    if(texas.size() == 0)
      return;

    head = texas.peek();
    if(tokenIsInstanceOfFunc(head))
      california.add(texas.pop());
  }

  private boolean tokenIsInstanceOfLeftParenthesis(final Token<?> token){
    return token instanceof LeftParenthesis;
  }

  private boolean tokenIsInstanceOfFunc(final Token<?> token) {
    return token instanceof Func;
  }

  @Override
  public String toString() {
    return ")";
  }
}
