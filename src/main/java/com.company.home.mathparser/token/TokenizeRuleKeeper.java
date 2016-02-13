package com.company.home.mathparser.token;

import com.company.home.mathparser.token.types.*;
import com.sun.org.apache.xpath.internal.operations.UnaryOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenizeRuleKeeper {

    private static final Logger LOG = LoggerFactory.getLogger(TokenizeRuleKeeper.class);

    private boolean duplicatedUnaryOperators(final Token<?> t) {
        final boolean b = instanceOfClass(UnaryOperation.class, t) &&
                t.getPreviousToken().isPresent() &&
                instanceOfClass(UnaryOperation.class, t.getPreviousToken().get());
        if(b)
            LOG.debug("Token {} is invalid because prev token is unary operation", t);


        return b;
    }

    private boolean duplicatedValueTokens(final Token<?> t) {
        final boolean b = instanceOfClass(Value.class, t) &&
                t.getPreviousToken().isPresent() &&
                instanceOfClass(Value.class, t.getPreviousToken().get());
        if(b)
            LOG.debug("Token {} is invalid because prev token is value", t);

        return b;
    }

    private boolean unaryOperationAfterValue(final Token<?> t) {
        final boolean b = instanceOfClass(UnaryOperator.class, t) &&
                t.getPreviousToken().isPresent() &&
                instanceOfClass(Value.class, t.getPreviousToken().get());

        if(b)
            LOG.debug("Token {} is invalid because prev token is value", t);

        return b;
    }

    private boolean unaryOperatorAfterRightParenthesis(final Token<?> t) {
        final boolean b = instanceOfClass(RightParenthesis.class, t) &&
                t.getPreviousToken().isPresent() &&
                instanceOfClass(UnaryOperator.class, t.getPreviousToken().get());

        if(b)
            LOG.debug("Token {} is invalid because prev token is right parenthesis", t);

        return b;
    }

    private boolean valueAfterRightParenthesis(final Token<?> t) {
        return instanceOfClass(RightParenthesis.class, t) &&
                t.getPreviousToken().isPresent() &&
                instanceOfClass(Value.class, t.getPreviousToken().get());
    }

//    private boolean firstUnaryOperatorInExprOnlyBeforeLeftParenthesis(final Token<?> t) {
//        return !t.getPreviousToken().isPresent() &&
//                instanceOfClass(UnaryOperator.class, t);
//    }

    private boolean binaryOperatorIsFirstInExpression(final Token<?> t) {
        boolean b = instanceOfClass(BinaryOperator.class, t) &&
                !t.getPreviousToken().isPresent();

        if(b)
            LOG.debug("Token {} is invalid because there are no prev tokens", t);

        return b;
    }

    private <T> boolean instanceOfClass(final Class<?> tClass, final T value) {
        return tClass.isAssignableFrom(value.getClass());
    }

    public boolean matchesAllRules(final Token<?> token) {
     return !duplicatedUnaryOperators(token) &&
             !duplicatedValueTokens(token) &&
             !unaryOperationAfterValue(token) &&
             !unaryOperatorAfterRightParenthesis(token) &&
             !valueAfterRightParenthesis(token) &&
             !binaryOperatorIsFirstInExpression(token);
    }
}
