package com.company.home.mathparser;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenTest
{
  @Test
  public void testTokenSubstring() throws Exception
  {
    final String expr = "2+3";
    final Token t = new Token(expr, 0, null);
    assertThat(t.getRemainingExpression()).isEqualTo("+3");
    assertThat(t.getValue()).isEqualTo("2");
  }
}