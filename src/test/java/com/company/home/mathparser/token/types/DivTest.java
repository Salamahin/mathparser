package com.company.home.mathparser.token.types;

import com.company.home.mathparser.token.NotEnoughOperands;
import org.assertj.core.api.StrictAssertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class DivTest
{

  private Div div;

  @Before
  public void setUp() throws Exception
  {
    div=new Div("", Optional.empty());
  }

  @Test
  public void testDoEvaluate() throws Exception
  {
    final Stack<Token<?>> values=new Stack<>();
    values.push(new Value(4));
    values.push(new Value(2));

    div.evaluate(values);

    assertThat(values).hasSize(1);
    StrictAssertions.assertThat(values.pop().getValue()).isEqualTo(2d);
  }

  @Test(expected=NotEnoughOperands.class)
  public void testNotEnoughData() throws Exception
  {
    final Stack<Token<?>> values=new Stack<>();
    values.push(new Value(4));
    div.evaluate(values);
  }
}