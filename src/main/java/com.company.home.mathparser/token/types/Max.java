package com.company.home.mathparser.token.types;

import java.util.Optional;
import java.util.Stack;

public class Max extends Func {
    public Max(final String remainingExpression, final Optional<Token<?>> prevToken) {
        super("max", remainingExpression, prevToken);
    }

    @Override
    public void evaluate(final Stack<Token<?>> stack) {
        final Value first = (Value) stack.pop();
        final Value second = (Value) stack.pop();
        stack.push(new Value(Math.max(first.getValue(), second.getValue())));
    }
}
