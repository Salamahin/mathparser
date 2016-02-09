package com.company.home.mathparser;

import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Chars;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Tokenizer
{
  private Queue<Character> expression;

  public Tokenizer(String expression)
  {
    this.expression=new LinkedList<>(Chars.asList(expression.toCharArray()));
  }

  private Character pollOneDigitOrNull()
  {
    Character c=expression.poll();
    if (c == null)
      return null;

    return Character.isDigit(c) ? c : null;
  }

  private String extractToken()
  {
    String token="";
    Character c;
    while ((c = pollOneDigitOrNull()) != null)
    {
      token+=c;
    }
    return token;
  }

  List<String> getTokens()
  {
    final List<String> tokens=new ArrayList<>();
    tokens.add(extractToken());
    return ImmutableList.copyOf(tokens);
  }
}
