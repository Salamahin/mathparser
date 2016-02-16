package com.company.home.mathparser.token;

class UnrecognizedExpression extends RuntimeException
{
  public UnrecognizedExpression(String message)
  {
    super(message);
  }
}
