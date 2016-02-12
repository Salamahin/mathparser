package com.company.home.mathparser.token.types;


import java.util.Optional;

public abstract class Operator extends Calculable implements Comparable<Operator>
{
  protected Operator(final String value, final String remainigExpression, final Optional<Token<?>> nextToken)
  {
    super(value, remainigExpression, nextToken);
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
