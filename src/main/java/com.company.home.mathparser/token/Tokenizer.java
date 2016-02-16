package com.company.home.mathparser.token;

import com.company.home.mathparser.token.producers.*;
import com.company.home.mathparser.token.types.Token;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class Tokenizer
{
  private static final List<TokenProducer> POSSIBLE_PRODUCERS=Lists.newArrayList(
      new ValueTokenProducer(),
      new UnaryOperationTokenProducer(),
      new BinaryOperationTokenProducer(),
      new ParenthesisTokenProducer(),
      new FunctionTokenProducer()
  );
  private static final TokenizeRuleKeeper TOKENIZE_RULES_KEEPER=new TokenizeRuleKeeper();
  private static final TokenCandidatesSelector TOKEN_CANDIDATES_SELECTOR=new TokenCandidatesSelector();

  public List<Token<?>> tokenize(final String expression)
  {
    String expr=expression.replaceAll(" ", "");
    final List<Token<?>> tokens=new LinkedList<>();

    Optional<Token<?>> prevToken=Optional.empty();

    while (!Strings.isNullOrEmpty(expr))
    {
      final Optional<Token<?>> recognizedToken=tryFindMatchingToken(expr, prevToken);

      if (!recognizedToken.isPresent())
        break;

      expr=recognizedToken.get().getRemainingExpression();
      prevToken=recognizedToken;
      tokens.add(recognizedToken.get());
    }

    if (!Strings.isNullOrEmpty(expr))
      throw new UnrecognizedExpression(expression);

    return ImmutableList.copyOf(tokens);
  }

  private Optional<Token<?>> tryFindMatchingToken(final String expr, final Optional<Token<?>> prevToken)
  {
    final List<Token<?>> candidates=POSSIBLE_PRODUCERS.stream()
        .map(p -> p.tryProduceToken(expr, prevToken))
        .filter(Optional::isPresent)
        .map(Optional::get)
        .filter(TOKENIZE_RULES_KEEPER::matchesAllRules)
        .collect(toList());

    return TOKEN_CANDIDATES_SELECTOR.select(candidates);
  }

}
