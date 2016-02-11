package com.company.home.mathparser.token.types;

import com.company.home.mathparser.token.UnbalancedException;

import java.util.List;
import java.util.Stack;

public final class FuncParamSep extends ExpressionToken<String> {
    public FuncParamSep() {
        super(",");
    }

    @Override
    public void organiseRPN(final List<ExpressionToken<?>> california, final Stack<ExpressionToken<?>> texas) {
        ExpressionToken<?> head = null;
        while (!texas.isEmpty()) {
            head = texas.peek();
            if(tokenIsInstanceOfLeftParenthesis(head))
                break;

            california.add(texas.pop());
        }

        if(!tokenIsInstanceOfLeftParenthesis(head))
            throw new UnbalancedException();
    }

    private boolean tokenIsInstanceOfLeftParenthesis(final ExpressionToken<?> t) {
        return t instanceof LeftParenthesis;
    }

    @Override
    public String toString() {
        return ",";
    }
}
