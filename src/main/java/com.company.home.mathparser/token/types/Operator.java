package com.company.home.mathparser.token.types;


public abstract class Operator extends Calculable implements Comparable<Operator>
{
  protected Operator(final String value)
  {
    super(value);
  }

  protected abstract int getPrecedence();

  @Override public final int compareTo(final Operator o)
  {
    return Integer.compare(getPrecedence(), o.getPrecedence());
  }

  @Override final public String toString()
  {
    return getValue();
  }
}
