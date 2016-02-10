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
      new TokenProducer.OperationTokenProducer(),
      new TokenProducer.ClosedParenthesisTokenProdicer(),
      new TokenProducer.OpenParenthesisTokenProducer()
  );

  private Optional<Token> tryProduceToken(final String expression, final Optional<TokenProducer> excludedProducer) {
    for(TokenProducer tp: possibleProducers) {
      if(excludedProducer.isPresent() && tp == excludedProducer.get())
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
    Optional<TokenProducer> excluded = Optional.empty();

    while (!Strings.isNullOrEmpty(expression) && (last=tryProduceToken(expression, excluded)).isPresent()) {
      final Token t = last.get();
      tokens.add(t.getValue());
      expression = t.getRemainingExpression();
      excluded = t.getExcludedProducer();
    }

    return ImmutableList.copyOf(tokens);

  }
}
