package com.company.home.mathparser;

import org.junit.Before;
import org.junit.Ignore;
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

  @Ignore
  @Test
  public void testCanEvaluate2() throws Exception
  {
    assertThat(parser.parse("2-2")).isEqualTo(0);
  }

  @Test
  public void canTokenize() throws Exception {

    assertThat(parser.tokenize("2.5+2")).contains("2.5");
  }
}