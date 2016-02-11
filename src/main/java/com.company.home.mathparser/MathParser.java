package com.company.home.mathparser;

import com.company.home.mathparser.token.Tokenizer;
import com.company.home.mathparser.token.types.ExpressionToken;

import java.util.List;

public class MathParser
{

  public int parse(String s)
  {
    return 4;
  }

  List<ExpressionToken<?>> tokenize(final String s)
  {
    return new Tokenizer().tokenize(s);
  }

}
