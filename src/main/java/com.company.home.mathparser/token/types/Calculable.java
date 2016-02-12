package com.company.home.mathparser.token.types;


import java.util.Optional;
import java.util.Stack;

public abstract class Calculable extends Token<String> {
    protected Calculable(final String value, final String remainingExpression, final Optional<Token<?>> prevToken) {
        super(value, remainingExpression, prevToken);
    }

    public abstract void evaluate(final Stack<Token<?>> stack);
}
