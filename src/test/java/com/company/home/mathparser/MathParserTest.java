package com.company.home.mathparser;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MathParserTest
{
  private MathParser parser;

  @Before
  public void setUp() throws Exception
  {
    parser = new MathParser();
  }

  @Test
  public void testCanEvaluate1() throws Exception
  {
    assertThat(parser.parse("2+2")).isEqualTo(4);
  }

  @Test
  public void testCanEvaluate2() throws Exception
  {
    assertThat(parser.parse("2-2")).isEqualTo(0);
  }
}