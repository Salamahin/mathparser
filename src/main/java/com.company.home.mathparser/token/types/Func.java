package com.company.home.mathparser.token.types;

import java.util.List;
import java.util.Stack;

public abstract class Func extends Calculable {

    protected Func(final String value) {
        super(value);
    }

    @Override
    public final void organiseRPN(final List<ExpressionToken<?>> california, final Stack<ExpressionToken<?>> texas) {
        texas.push(this);
    }

    @Override
    public final String toString() {
        return getValue();
    }
}
