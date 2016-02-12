package com.company.home.mathparser.token;

import com.company.home.mathparser.token.types.ExpressionToken;
import com.google.common.collect.Lists;
import org.assertj.core.data.Percentage;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.company.home.mathparser.token.Commons.toListOfString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Percentage.*;

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
    final List<ExpressionToken<?>> rpn= shuntingYard.toRPN(tokens);

    assertThat(toListOfString(rpn)).isEqualTo(expectedList);
  }

  @Test
  public void testParenthesisWorking() throws Exception
  {
    final String expression="3 * (1 + 2)";
    final List<String> expectedList=Lists.newArrayList("3.0", "1.0", "2.0", "+", "*");

    final List<ExpressionToken<?>> tokens=tokenizer.tokenize(expression);
    final List<ExpressionToken<?>> rpn= shuntingYard.toRPN(tokens);

    assertThat(toListOfString(rpn)).isEqualTo(expectedList);
  }

  @Test
  public void testWorking2() throws Exception
  {
    final String expression="abs ( max ( 2 , 3 ) / 3 * 3.1415 )";
    final List<String> expectedList=Lists.newArrayList("2.0", "3.0", "max", "3.0", "/", "3.1415", "*", "abs");

    final List<ExpressionToken<?>> tokens=tokenizer.tokenize(expression);
    final List<ExpressionToken<?>> rpn= shuntingYard.toRPN(tokens);

    assertThat(toListOfString(rpn)).isEqualTo(expectedList);
  }

  @Test(expected = UnbalancedException.class)
  public void testUnbalanced1() throws Exception
  {
    final String expression="3 + 4 * 2 / ( 1 - 5 ";
    final List<ExpressionToken<?>> tokens=tokenizer.tokenize(expression);
    shuntingYard.toRPN(tokens);
  }

  @Test(expected = UnbalancedException.class)
  public void testUnbalanced2() throws Exception
  {
    final String expression="3 + max( 1 - 5 , 2 + 3";
    final List<ExpressionToken<?>> tokens=tokenizer.tokenize(expression);
    shuntingYard.toRPN(tokens);
  }

  @Test
  public void testEvaluate1() throws Exception
  {
    final String expression = "5 + ((1 + 2) * 4) - 3";
    final List<ExpressionToken<?>> tokens=tokenizer.tokenize(expression);
    final List<ExpressionToken<?>> rpn=shuntingYard.toRPN(tokens);
    assertThat(shuntingYard.evaluate(rpn)).isCloseTo(14, withPercentage(0.1));
  }

  @Test
  public void testEvaluate2() throws Exception
  {
    final String expression = "-5 - (-(1 + 2) * 4) - 3";
    final List<ExpressionToken<?>> tokens=tokenizer.tokenize(expression);
    final List<ExpressionToken<?>> rpn=shuntingYard.toRPN(tokens);
    assertThat(shuntingYard.evaluate(rpn)).isCloseTo(4, withPercentage(0.1));
  }
}