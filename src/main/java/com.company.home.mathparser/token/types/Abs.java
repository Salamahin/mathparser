package com.company.home.mathparser.token.types;

import java.util.Stack;

public final class Abs extends Func {

    public Abs() {
        super("abs");
    }

    @Override
    public void evaluate(final Stack<ExpressionToken<?>> stack) {
        final Value v = (Value) stack.pop();
        stack.push(new Value(Math.abs(v.getValue())));
    }
}
