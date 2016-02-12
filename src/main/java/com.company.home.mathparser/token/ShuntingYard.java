package com.company.home.mathparser.token;

import com.company.home.mathparser.token.types.Calculable;
import com.company.home.mathparser.token.types.ExpressionToken;
import com.company.home.mathparser.token.types.Operator;
import com.company.home.mathparser.token.types.Value;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ShuntingYard
{
  private final List<ExpressionToken<?>> california;
  private final Stack<ExpressionToken<?>> texas;

  public ShuntingYard()
  {
    california= new LinkedList<>();
    texas= new Stack<>();
  }

  public List<ExpressionToken<?>> toRPN(final List<ExpressionToken<?>> input) {
    for(ExpressionToken<?> t: input)
      t.organiseRPN(california, texas);

    while (!texas.empty()) {
      ExpressionToken<?> head = texas.pop();
      if(!tokenInstanceOfOperator(head))
        throw new UnbalancedException();

      california.add(head);
    }

    return california;
  }

  public double evaluate(final List<ExpressionToken<?>> reversePolishNotation) {
    final Stack<ExpressionToken<?>> stack = new Stack<>();
    for(ExpressionToken<?> t: reversePolishNotation) {
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

  private boolean tokenInstanceOfOperator(final ExpressionToken<?> t) {
    return t instanceof Operator;
  }
}
