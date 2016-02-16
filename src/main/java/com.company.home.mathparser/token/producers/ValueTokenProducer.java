package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.types.Token;
import com.company.home.mathparser.token.types.Value;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValueTokenProducer implements TokenProducer {
    private static final Pattern pattern = Pattern.compile("^[+-]?[0-9]*\\.?[0-9]+");

    @Override
    public Optional<Token<?>> tryProduceToken(final String expression, final Optional<Token<?>> prevToken) {
        final Matcher m = pattern.matcher(expression);
        if (!m.find())
            return Optional.empty();

        return Optional.of(getTokenInfo(expression, m.group(0), prevToken));
    }

    private Value getTokenInfo(final String expression, final String matchedGroup, final Optional<Token<?>> prevToken) {
        return new Value(
                Double.valueOf(matchedGroup),
                expression.substring(matchedGroup.length()),
                prevToken
        );
    }
}
