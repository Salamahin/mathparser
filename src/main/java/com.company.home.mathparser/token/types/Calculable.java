package com.company.home.mathparser.token.types;


import java.util.Stack;

public abstract class Calculable extends ExpressionToken<String> {
    public Calculable(String value) {
        super(value);
    }

    public abstract void evaluate(final Stack<ExpressionToken<?>> stack);
}
