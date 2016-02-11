package com.company.home.mathparser.token;

import com.company.home.mathparser.token.producers.*;
import com.company.home.mathparser.token.types.ExpressionToken;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Tokenizer
{
  private static final List<TokenProducer> possibleProducers =Lists.newArrayList(
      ValueTokenProducer.getInstance(),
      UnaryOperationTokenProducer.getInstance(),
      BinaryOperationTokenProducer.getInstance(),
      ParenthesisTokenProducer.getInstance()
  );

  private Optional<TokenInformation> produceAnyToken(final String expression, final List<TokenProducer> excludedProducers) {
    for(TokenProducer tp: possibleProducers) {
      if(excludedProducers.contains(tp))
        continue;

      final Optional<TokenInformation> t = tp.tryProduceToken(expression);
      if(t.isPresent())
        return t;
    }

    return Optional.empty();
  }

  public List<ExpressionToken<?>> tokenize(String expression) {
    final List<ExpressionToken<?>> tokens = new LinkedList<>();

    Optional<TokenInformation> last;
    List<TokenProducer> excluded = new ArrayList<>();

    while (!Strings.isNullOrEmpty(expression) && (last=produceAnyToken(expression, excluded)).isPresent()) {
      final TokenInformation t = last.get();
      tokens.add(t.getTokenValue());
      expression = t.getRemainingExpression();
      excluded = t.getExcludedProducers();
    }

    return ImmutableList.copyOf(tokens);
  }
}
