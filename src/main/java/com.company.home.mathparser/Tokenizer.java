package com.company.home.mathparser;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

class Tokenizer
{
  private static final List<TokenProducer> possibleProducers =Lists.newArrayList(
      new TokenProducer.NumberTokenProducer(),
      new TokenProducer.OperationTokenProducer()
  );

  private Optional<Token> tryProduceToken(final String expression, final TokenProducer excludedProducer) {
    for(TokenProducer tp: possibleProducers) {
      if(tp == excludedProducer)
        continue;

      Optional<Token> t = tp.tryProduceToken(expression);
      if(t.isPresent())
        return t;
    }

    return Optional.empty();
  }

  List<String> getTokens(String expression) {
    final List<String> tokens = new LinkedList<>();
    Optional<Token> last;

    TokenProducer excluded = null;
    while (!Strings.isNullOrEmpty(expression) && (last=tryProduceToken(expression, excluded)).isPresent()) {
      final Token t = last.get();
      tokens.add(t.getValue());
      expression = t.getRemainingExpression();
      excluded = t.getProducer();
    }

    return ImmutableList.copyOf(tokens);

  }
}
