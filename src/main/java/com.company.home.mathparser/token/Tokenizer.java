package com.company.home.mathparser.token;

import com.company.home.mathparser.token.producers.*;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Tokenizer
{
  private static final List<TokenProducer> possibleProducers =Lists.newArrayList(
      new NumberTokenProducer(),
      new OperationTokenProducer(),
      new ClosedParenthesisTokenProducer(),
      new OpenParenthesisTokenProducer()
  );

  private Optional<Token> produceAnyToken(final String expression, final Optional<TokenProducer> excludedProducer) {
    for(TokenProducer tp: possibleProducers) {
      if(excludedProducer.isPresent() && tp == excludedProducer.get())
        continue;

      final Optional<Token> t = tp.tryProduceToken(expression);
      if(t.isPresent())
        return t;
    }

    return Optional.empty();
  }

  public List<String> tokenize(String expression) {
    final List<String> tokens = new LinkedList<>();

    Optional<Token> last;
    Optional<TokenProducer> excluded = Optional.empty();

    while (!Strings.isNullOrEmpty(expression) && (last=produceAnyToken(expression, excluded)).isPresent()) {
      final Token t = last.get();
      tokens.add(t.getValue());
      expression = t.getRemainingExpression();
      excluded = t.getExcludedProducer();
    }

    return ImmutableList.copyOf(tokens);

  }
}
