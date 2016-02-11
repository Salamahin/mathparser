package com.company.home.mathparser.token.types;

public abstract class Operator extends ExpressionToken<String> implements Comparable<Operator>
{
  protected Operator(String value)
  {
    super(value);
  }

  protected abstract int getPrecedence();

  @Override public final int compareTo(Operator o)
  {
    return Integer.compare(getPrecedence(), o.getPrecedence());
  }

  @Override final public String toString()
  {
    return getValue();
  }
}
