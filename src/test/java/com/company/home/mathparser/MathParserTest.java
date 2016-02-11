package com.company.home.mathparser;

import com.company.home.mathparser.token.types.ExpressionToken;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.*;
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



}