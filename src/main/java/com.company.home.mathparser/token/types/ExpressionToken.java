package com.company.home.mathparser.token.types;

import com.company.home.mathparser.token.TokenInformation;

import java.util.List;
import java.util.Stack;

public abstract class ExpressionToken<T>
{
  private final T value;

  public ExpressionToken(T value)
  {
    this.value=value;
  }

  public final T getValue()
  {
    return value;
  }

  public abstract void organiseRPN(final List<ExpressionToken<?>> california, final Stack<ExpressionToken<?>> texas);
}
