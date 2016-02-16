package com.company.home.mathparser.token.types;


import java.util.Optional;

public abstract class Operator extends Calculable implements Comparable<Operator>
{
  Operator(final String value, final String remainingExpression, final Optional<Token<?>> nextToken)
  {
    super(value, remainingExpression, nextToken);
  }

  protected abstract Precedence getPrecedence();

  @Override public final int compareTo(final Operator o)
  {
    return getPrecedence().compareTo(o.getPrecedence());
  }

  @Override final public String toString()
  {
    return getValue();
  }
}
