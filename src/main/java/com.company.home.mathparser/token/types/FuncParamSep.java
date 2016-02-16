package com.company.home.mathparser.token.types;

import com.company.home.mathparser.token.UnbalancedException;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public final class FuncParamSep extends Token<String> {
    public FuncParamSep(final String remainingExpression, final Optional<Token<?>> prevToken) {
        super(",", remainingExpression, prevToken);
    }

    @Override
    public void organiseRPN(final List<Token<?>> california, final Stack<Token<?>> texas) {
        Token<?> head = null;
        while (!texas.isEmpty()) {
            head = texas.peek();
            if(isLeftParenthesis(head))
                break;

            california.add(texas.pop());
        }

        if(!isLeftParenthesis(head))
            throw new UnbalancedException();
    }

    private boolean isLeftParenthesis(final Token<?> t) {
        return t instanceof LeftParenthesis;
    }

    @Override
    public String toString() {
        return ",";
    }
}
