package com.company.home.mathparser.token;

import com.company.home.mathparser.token.types.Token;
import com.company.home.mathparser.token.types.UnaryMinus;
import com.company.home.mathparser.token.types.Value;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class TokenCandidatesSelector
{
  private static final Comparator<Token<?>> UNARY_MINUS_AND_VALUE_COMPARATOR=new Comparator<Token<?>>()
  {
    private boolean isUnaryMinus(Token<?> o1)
    {
      return o1 instanceof UnaryMinus;
    }

    private int getCompareResult(final Value v)
    {
      if (v.getValue() < 0)
        return -1;
      return 1;
    }

    @Override public int compare(final Token<?> o1, final Token<?> o2)
    {
      if(o1 instanceof Value && o2 instanceof UnaryMinus)
        return getCompareResult((Value)o1);

      if(o2 instanceof Value && o1 instanceof UnaryMinus)
        return -getCompareResult((Value)o2);

      return 0;
    }
  };

  Optional<Token<?>> select(final List<Token<?>> candidates)
  {
    if (candidates.size() == 0)
      return Optional.empty();
    if (candidates.size() == 1)
      return Optional.of(candidates.get(0));

    return candidates.stream()
        .sorted(UNARY_MINUS_AND_VALUE_COMPARATOR)
        .findFirst();
  }

}
