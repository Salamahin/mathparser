package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.types.Abs;
import com.company.home.mathparser.token.types.FuncParamSep;
import com.company.home.mathparser.token.types.Max;
import com.company.home.mathparser.token.types.Token;

import java.util.Optional;

public class FunctionTokenProducer implements TokenProducer {
    private Optional<Token<?>> tryProduceFuncSeparator(final String expression, final Optional<Token<?>> prevToken) {
        if(expression.charAt(0) != ',')
            return Optional.empty();

        return Optional.of(new FuncParamSep(expression.substring(1), prevToken));
    }

    private static abstract class FuncTokenProducer {
        abstract String getFuncName();
        abstract Token<?> produce(final String regainingExpression, final Optional<Token<?>> prevToken);

        final Optional<Token<?>> tryProduce(final String expression, final Optional<Token<?>> prevToken) {
            final String pattern = getFuncName();
            final String actual = expression.substring(0, Math.min(pattern.length(), expression.length()));

            if (!pattern.equalsIgnoreCase(actual))
                return Optional.empty();

            return Optional.of(produce(expression.substring(pattern.length()), prevToken));
        }
    }
    private static final FuncTokenProducer ABS_PRODUCER = new FuncTokenProducer() {

        @Override
        String getFuncName() {
            return "abs";
        }

        @Override
        Token<?> produce(final String regainingExpression, final Optional<Token<?>> prevToken) {
            return new Abs(regainingExpression, prevToken);
        }
    };
    private static final FuncTokenProducer MAX_PRODUCER = new FuncTokenProducer() {
        @Override
        String getFuncName() {
            return "max";
        }

        @Override
        Token<?> produce(final String remainingExpression, final Optional<Token<?>> prevToken) {
            return new Max(remainingExpression, prevToken);
        }
    };

    @Override public Optional<Token<?>> tryProduceToken(final String expression, final Optional<Token<?>> prevToken) {
        Optional<Token<?>> res = tryProduceFuncSeparator(expression, prevToken);
        if(res.isPresent())
            return res;

        res = ABS_PRODUCER.tryProduce(expression, prevToken);
        if(res.isPresent())
            return res;

        return MAX_PRODUCER.tryProduce(expression, prevToken);
    }
}
