package com.company.home.mathparser.token;

public class UnrecognizedExpression extends RuntimeException
{
  public UnrecognizedExpression(String message)
  {
    super(message);
  }
}
