package com.company.home.mathparser.token;

import com.company.home.mathparser.token.types.Calculable;
import com.company.home.mathparser.token.types.Token;
import com.company.home.mathparser.token.types.Operator;
import com.company.home.mathparser.token.types.Value;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ShuntingYard
{
  private final List<Token<?>> california;
  private final Stack<Token<?>> texas;

  public ShuntingYard()
  {
    california= new LinkedList<>();
    texas= new Stack<>();
  }

  public List<Token<?>> toRPN(final List<Token<?>> input) {
    for(Token<?> t: input)
      t.organiseRPN(california, texas);

    while (!texas.empty()) {
      Token<?> head = texas.pop();
      if(!tokenInstanceOfOperator(head))
        throw new UnbalancedException();

      california.add(head);
    }

    return california;
  }

  public double evaluate(final List<Token<?>> reversePolishNotation) {
    final Stack<Token<?>> stack = new Stack<>();
    for(Token<?> t: reversePolishNotation) {
      if(t instanceof Value)
      {
        stack.push(t);
        continue;
      }

      if(t instanceof Calculable) {
        final Calculable calculable=(Calculable) t;
        calculable.evaluate(stack);
      }
    }

    if(stack.size() != 1)
      throw new EvaluationError();

    final Value v =(Value) stack.pop();

    return v.getValue();
  }

  private boolean tokenInstanceOfOperator(final Token<?> t) {
    return t instanceof Operator;
  }
}
