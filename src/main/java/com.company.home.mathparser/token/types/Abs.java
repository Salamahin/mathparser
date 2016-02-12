package com.company.home.mathparser.token.types;

import java.util.Optional;
import java.util.Stack;

public final class Abs extends Func {

    public Abs(final String remainiExpression, final Optional<Token<?>> prevToken) {
        super("abs", remainiExpression, prevToken);
    }

    @Override
    public void evaluate(final Stack<Token<?>> stack) {
        final Value v = (Value) stack.pop();
        stack.push(new Value(Math.abs(v.getValue())));
    }
}
