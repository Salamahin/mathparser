package com.company.home.mathparser.token;

import com.company.home.mathparser.token.producers.*;
import com.company.home.mathparser.token.types.ExpressionToken;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Tokenizer
{
  private static final List<TokenProducer> possibleProducers =Lists.newArrayList(
      new ValueTokenProducer(),
      new UnaryOperationTokenProducer(),
      new BinaryOperationTokenProducer(),
      new ParenthesisTokenProducer()
  );

  private Optional<TokenInformation> produceAnyToken(final String expression, final Optional<TokenProducer> excludedProducer) {
    for(TokenProducer tp: possibleProducers) {
      if(excludedProducer.isPresent() && tp == excludedProducer.get())
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
    Optional<TokenProducer> excluded = Optional.empty();

    while (!Strings.isNullOrEmpty(expression) && (last=produceAnyToken(expression, excluded)).isPresent()) {
      final TokenInformation t = last.get();
      tokens.add(t.getTokenValue());
      expression = t.getRemainingExpression();
      excluded = t.getExcludedProducer();
    }

    return ImmutableList.copyOf(tokens);
  }
}
