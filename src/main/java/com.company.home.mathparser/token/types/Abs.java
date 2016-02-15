package com.company.home.mathparser.token.types;

import com.company.home.mathparser.token.NotEnoughOperands;

import java.util.Optional;
import java.util.Stack;

public final class Abs extends Func {

    public Abs(final String remainingExpression, final Optional<Token<?>> prevToken) {
        super("abs", remainingExpression, prevToken);
    }

    @Override
    public void evaluate(final Stack<Token<?>> stack) {
        if(stack.size() < 1)
            throw new NotEnoughOperands();

        final Value v = (Value) stack.pop();
        stack.push(new Value(Math.abs(v.getValue())));
    }
}
