package com.company.home.mathparser.token.types;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public abstract class Func extends Calculable {

    Func(final String value, final String remainingExpression, final Optional<Token<?>> prevToken) {
        super(value, remainingExpression, prevToken);
    }

    @Override
    public final void organiseRPN(final List<Token<?>> california, final Stack<Token<?>> texas) {
        texas.push(this);
    }

    @Override
    public final String toString() {
        return getValue();
    }
}
