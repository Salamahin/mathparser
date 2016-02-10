package com.company.home.mathparser;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

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
    final String expression="-2.25*(3+63)";
    final List<String> expectedTokens=Lists.newArrayList("-2.25", "*", "(", "3", "+", "63", ")");
    assertThat(parser.tokenize(expression)).isEqualTo(expectedTokens);
  }
}