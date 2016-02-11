package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.TokenInformation;
import com.company.home.mathparser.token.types.*;

import java.util.Optional;

public class FunctionTokenProducer implements TokenProducer {
    private static class InstanceHolder {
        private static final TokenProducer INSTANCE = new FunctionTokenProducer();
    }

    private FunctionTokenProducer() {

    }

    public static TokenProducer getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private Optional<TokenInformation> tryProduceFuncSeparator(final String expression) {
        if(expression.charAt(0) != ',')
            return Optional.empty();

        return Optional.of(new TokenInformation(new FuncParamSep(), expression.substring(1)));
    }

    private Optional<TokenInformation> tryProduceByFuncName(final Func func, final String expression) {
        final String pattern = func.getValue();
        final String actual = expression.substring(0, pattern.length());

        if (!pattern.equalsIgnoreCase(actual))
            return Optional.empty();

        return Optional.of(new TokenInformation(func, expression.substring(pattern.length())));
    }

    @Override
    public Optional<TokenInformation> tryProduceToken(final String expression) {
        Optional<TokenInformation> res = tryProduceFuncSeparator(expression);
        if(res.isPresent())
            return res;

        res = tryProduceByFuncName(new Abs(), expression);
        if(res.isPresent())
            return res;

        res = tryProduceByFuncName(new Max(), expression);
        if(res.isPresent())
            return res;

        return Optional.empty();
    }
}
