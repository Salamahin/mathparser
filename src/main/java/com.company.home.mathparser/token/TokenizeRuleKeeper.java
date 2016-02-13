package com.company.home.mathparser.token;

import com.company.home.mathparser.token.types.Token;
import com.company.home.mathparser.token.types.Value;
import com.sun.org.apache.xpath.internal.operations.UnaryOperation;

public class TokenizeRuleKeeper {

    private boolean duplicatedUnaryOperators(final Token<?> t) {
        return instanceOfClass(UnaryOperation.class, t) &&
                t.getPreviousToken().isPresent() &&
                instanceOfClass(UnaryOperation.class, t.getPreviousToken().get());
    }

    private boolean dublicatedValueTokens(final Token<?> t) {
        return instanceOfClass(Value.class, t) &&
                t.getPreviousToken().isPresent() &&
                instanceOfClass(Value.class, t.getPreviousToken().get());
    }


    private <T> boolean instanceOfClass(final Class<?> tClass, final T value) {
        return value.getClass().isAssignableFrom(tClass);
    }

    public boolean matchesAllRules(Token<?> token) {
     return !duplicatedUnaryOperators(token) &&
             !dublicatedValueTokens(token);
    }
}
