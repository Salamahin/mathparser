package com.company.home.mathparser.token.types;

import com.company.home.mathparser.token.UnbalancedException;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public final class FuncParamSep extends Token<String> {
    public FuncParamSep(final String remainigExpression, final Optional<Token<?>> prevToken) {
        super(",", remainigExpression, prevToken);
    }

    @Override
    public void organiseRPN(final List<Token<?>> california, final Stack<Token<?>> texas) {
        Token<?> head = null;
        while (!texas.isEmpty()) {
            head = texas.peek();
            if(tokenIsInstanceOfLeftParenthesis(head))
                break;

            california.add(texas.pop());
        }

        if(!tokenIsInstanceOfLeftParenthesis(head))
            throw new UnbalancedException();
    }

    private boolean tokenIsInstanceOfLeftParenthesis(final Token<?> t) {
        return t instanceof LeftParenthesis;
    }

    @Override
    public String toString() {
        return ",";
    }
}
