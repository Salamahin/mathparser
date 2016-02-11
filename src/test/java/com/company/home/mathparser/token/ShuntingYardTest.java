package com.company.home.mathparser.token;

import com.company.home.mathparser.token.types.ExpressionToken;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShuntingYardTest
{
  private Tokenizer tokenizer;
  private ShuntingYard shuntingYard;

  @Before
  public void setUp() throws Exception
  {
    tokenizer=new Tokenizer();
    shuntingYard =new ShuntingYard();
  }

  @Test
  public void testWorking1() throws Exception
  {
    final String expression="3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3";
    final List<String> expectedList=Lists.newArrayList("3.0", "4.0", "2.0", "*", "1.0", "5.0", "-", "2.0", "3.0", "^", "^", "/", "+");

    final List<ExpressionToken<?>> tokens=tokenizer.tokenize(expression);
    final List<String> rpn= shuntingYard.toRPN(tokens);

    assertThat(rpn).isEqualTo(expectedList);
  }

  @Test
  public void testParenthesisWorking() throws Exception
  {
    final String expression="3 * (1 + 2)";
    final List<String> expectedList=Lists.newArrayList("3.0", "1.0", "2.0", "+", "*");

    final List<ExpressionToken<?>> tokens=tokenizer.tokenize(expression);
    final List<String> rpn= shuntingYard.toRPN(tokens);

    assertThat(rpn).isEqualTo(expectedList);
  }

  @Test
  public void testWorking2() throws Exception
  {
    final String expression="abs ( max ( 2 , 3 ) / 3 * 3.1415 )";
    final List<String> expectedList=Lists.newArrayList("2.0", "3.0", "max", "3.0", "/", "3.1415", "*", "abs");

    final List<ExpressionToken<?>> tokens=tokenizer.tokenize(expression);
    final List<String> rpn= shuntingYard.toRPN(tokens);

    assertThat(rpn).isEqualTo(expectedList);
  }
}