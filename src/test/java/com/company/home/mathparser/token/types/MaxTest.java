package com.company.home.mathparser.token.types;

import com.company.home.mathparser.token.NotEnoughOperands;
import org.assertj.core.api.StrictAssertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class MaxTest
{
  private Max max;

  @Before
  public void setUp() throws Exception
  {
    max=new Max("", Optional.empty());
  }

  @Test
  public void testEvaluate() throws Exception
  {
    final Stack<Token<?>> values=new Stack<>();
    values.push(new Value(-11));
    values.push(new Value(0));

    max.evaluate(values);

    assertThat(values).hasSize(1);
    StrictAssertions.assertThat(values.pop().getValue()).isEqualTo(0d);
  }

  @Test(expected=NotEnoughOperands.class)
  public void testNotEnoughData() throws Exception
  {
    final Stack<Token<?>> values=new Stack<>();
    values.push(new Value(4));
    max.evaluate(values);
  }
}