package com.company.home.mathparser.token;

import com.company.home.mathparser.token.producers.*;
import com.company.home.mathparser.token.types.Token;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Tokenizer {
    private static final Logger LOG = LoggerFactory.getLogger(Tokenizer.class);

    private static final List<TokenProducer> POSSIBLE_PRODUCERS = Lists.newArrayList(
            ValueTokenProducer.getInstance(),
            UnaryOperationTokenProducer.getInstance(),
            BinaryOperationTokenProducer.getInstance(),
            ParenthesisTokenProducer.getInstance(),
            FunctionTokenProducer.getInstance()
    );
    private static final TokenizeRuleKeeper TOKENIZE_RULES_KEEPER = new TokenizeRuleKeeper();

    public List<Token<?>> tokenize(final String expression) {
        String expr = expression.replaceAll(" ", "");
        final List<Token<?>> tokens = new LinkedList<>();

        Optional<Token<?>> pretToken = Optional.empty();

        while (!Strings.isNullOrEmpty(expr)) {
            final Optional<Token<?>> recognizedToken = tryFindMatchingToken(expr, pretToken);

            if (!recognizedToken.isPresent())
                break;

            expr = recognizedToken.get().getRemainigExpression();
            pretToken = recognizedToken;
            tokens.add(recognizedToken.get());
        }

        if (!Strings.isNullOrEmpty(expr))
            throw new UnrecognizedExpression(expression);

        return ImmutableList.copyOf(tokens);
    }

    private Optional<Token<?>> tryFindMatchingToken(final String expr, final Optional<Token<?>> prevToken) {
        final List<Token<?>> candidates = POSSIBLE_PRODUCERS.stream()
                .map(p -> p.tryProduceToken(expr, prevToken))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(TOKENIZE_RULES_KEEPER::matchesAllRules)
                .collect(toList());

        if(candidates.size() == 0) {
            LOG.debug("Parsing expression [{}] failed", expr);
            return Optional.empty();
        }

        if(candidates.size() > 1) {
            LOG.warn("Several possible candidates, the expression might be tokenized incorrectly: {}; {}", expr, candidates);
        }

        return Optional.of(candidates.get(0));
    }
}
