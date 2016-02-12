package com.company.home.mathparser.token;

import com.company.home.mathparser.token.producers.*;
import com.company.home.mathparser.token.types.Token;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Tokenizer
{
  private static final List<TokenProducer> possibleProducers=Lists.newArrayList(
      ValueTokenProducer.getInstance(),
      UnaryOperationTokenProducer.getInstance(),
      BinaryOperationTokenProducer.getInstance(),
      ParenthesisTokenProducer.getInstance(),
      FunctionTokenProducer.getInstance()
  );

//  private Optional<Token<?>> produceAnyToken(final String expression, final List<TokenProducer> excludedProducers)
//  {
//    Optional<Token<?>> prev = Optional.empty();
//    for (TokenProducer tp : possibleProducers)
//    {
//      if (excludedProducers.contains(tp))
//        continue;
//
//      final Optional<Token<?>> t=tp.tryProduceToken(expression, prev);
//      if (t.isPresent())
//        return t;
//    }
//
//    return Optional.empty();
//  }

  public List<Token<?>> tokenize(final String expression)
  {
    String expr=expression.replaceAll(" ", "");
    final List<Token<?>> tokens=new LinkedList<>();

    Optional<TokenInformation> last;
    List<TokenProducer> excluded=new ArrayList<>();

    while (!Strings.isNullOrEmpty(expr) && (last=produceAnyToken(expr, excluded)).isPresent())
    {
      final TokenInformation t=last.get();
      tokens.add(t.getTokenValue());
      expr=t.getRemainingExpression();
      excluded=t.getExcludedProducers();
    }

    if (!Strings.isNullOrEmpty(expr))
      throw new UnrecognizedExpression(expression);

    return ImmutableList.copyOf(tokens);
  }
}
