package com.company.home.mathparser;

import com.company.home.mathparser.token.ShuntingYard;
import com.company.home.mathparser.token.Tokenizer;

class MathParser
{
  private final ShuntingYard evaluator = new ShuntingYard();
  private final Tokenizer tokenizer = new Tokenizer();

  public double parse(final String s)
  {
    return evaluator.evaluate(evaluator.toRPN(tokenizer.tokenize(s)));
  }

}
