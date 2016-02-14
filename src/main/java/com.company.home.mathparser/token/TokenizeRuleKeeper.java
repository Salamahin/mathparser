package com.company.home.mathparser.token;

import com.company.home.mathparser.token.types.*;

public class TokenizeRuleKeeper {

    private boolean duplicatedUnaryOperators(final Token<?> t) {
        return instanceOfClass(UnaryOperator.class, t) &&
                t.getPreviousToken().isPresent() &&
                instanceOfClass(UnaryOperator.class, t.getPreviousToken().get());
    }

    private boolean duplicatedValueTokens(final Token<?> t) {
        return instanceOfClass(Value.class, t) &&
                t.getPreviousToken().isPresent() &&
                instanceOfClass(Value.class, t.getPreviousToken().get());
    }

    private  boolean duplicatedBinaryOperators(final Token<?> t) {
        return instanceOfClass(BinaryOperator.class, t) &&
                t.getPreviousToken().isPresent() &&
                instanceOfClass(BinaryOperator.class, t.getPreviousToken().get());
    }

    private boolean binaryOperatorAfterUnary(final Token<?> t) {
        return instanceOfClass(BinaryOperator.class, t) &&
                t.getPreviousToken().isPresent() &&
                instanceOfClass(UnaryOperator.class, t.getPreviousToken().get());
    }

    private boolean unaryOperationAfterValue(final Token<?> t) {
        return instanceOfClass(UnaryOperator.class, t) &&
                t.getPreviousToken().isPresent() &&
                instanceOfClass(Value.class, t.getPreviousToken().get());
    }

    private boolean unaryOperatorAfterRightParenthesis(final Token<?> t) {
        return instanceOfClass(UnaryOperator.class, t) &&
                t.getPreviousToken().isPresent() &&
                instanceOfClass(RightParenthesis.class, t.getPreviousToken().get());
    }

    private boolean valueAfterRightParenthesis(final Token<?> t) {
        return instanceOfClass(Value.class, t) &&
                t.getPreviousToken().isPresent() &&
                instanceOfClass(RightParenthesis.class, t.getPreviousToken().get());
    }

    private boolean binaryOperatorIsFirstInExpression(final Token<?> t) {
        return instanceOfClass(BinaryOperator.class, t) &&
                !t.getPreviousToken().isPresent();
    }

    private boolean binaryOperatorAfterLeftParenthesis(final Token<?> t) {
        return instanceOfClass(BinaryOperator.class, t) &&
                t.getPreviousToken().isPresent() &&
                instanceOfClass(LeftParenthesis.class, t.getPreviousToken().get());
    }

    private boolean binaryOperatorAfterFuncParamSeparator(final Token<?> t) {
        return instanceOfClass(BinaryOperator.class, t) &&
                t.getPreviousToken().isPresent() &&
                instanceOfClass(FuncParamSep.class, t.getPreviousToken().get());
    }

    private <T> boolean instanceOfClass(final Class<?> tClass, final T value) {
        return tClass.isAssignableFrom(value.getClass());
    }

    public boolean matchesAllRules(final Token<?> token) {
     return !duplicatedUnaryOperators(token) &&
             !duplicatedValueTokens(token) &&
             !duplicatedBinaryOperators(token) &&
             !unaryOperationAfterValue(token) &&
             !unaryOperatorAfterRightParenthesis(token) &&
             !valueAfterRightParenthesis(token) &&
             !binaryOperatorIsFirstInExpression(token) &&
             !binaryOperatorAfterLeftParenthesis(token) &&
             !binaryOperatorAfterUnary(token) &&
             !binaryOperatorAfterFuncParamSeparator(token);
    }
}
