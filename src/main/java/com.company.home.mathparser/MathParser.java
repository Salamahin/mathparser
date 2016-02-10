package com.company.home.mathparser;

import com.company.home.mathparser.token.Tokenizer;

import java.util.List;

public class MathParser
{

  public int parse(String s)
  {
    return 4;
  }

  List<String> tokenize(final String s)
  {
    return new Tokenizer().tokenize(s);
  }

}
