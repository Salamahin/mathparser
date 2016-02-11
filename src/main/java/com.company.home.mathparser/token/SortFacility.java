package com.company.home.mathparser.token;

import com.company.home.mathparser.token.types.ExpressionToken;
import com.company.home.mathparser.token.types.Operator;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static java.util.stream.Collectors.toList;

public class SortFacility
{
  private final List<ExpressionToken<?>> california;
  private final Stack<ExpressionToken<?>> texas;

  public SortFacility()
  {
    california= new LinkedList<>();
    texas= new Stack<>();
  }

  public List<String> toRPN(final List<ExpressionToken<?>> input) {
    for(ExpressionToken<?> t: input)
      t.organiseRPN(california, texas);

    while (!texas.empty()) {
      ExpressionToken<?> head = texas.pop();
      if(!tokenInstanceOfOperator(head))
        throw new UnbalancedException();

      california.add(head);
    }

    return california.stream()
        .map(Object::toString)
        .collect(toList());

  }

  private boolean tokenInstanceOfOperator(final ExpressionToken<?> t) {
    return t instanceof Operator;
  }

}
