package com.company.home.mathparser.token.types;

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
}
