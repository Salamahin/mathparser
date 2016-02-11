package com.company.home.mathparser.token.types;

import java.util.Stack;

public class Max extends Func {
    public Max() {
        super("max");
    }

    @Override
    public void evaluate(final Stack<ExpressionToken<?>> stack) {
        final Value first = (Value) stack.pop();
        final Value second = (Value) stack.pop();
        stack.push(new Value(Math.max(first.getValue(), second.getValue())));
    }
}
