package com.company.home.mathparser.token.types;

import com.company.home.mathparser.token.NotEnoughOperands;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class AbsTest
{

  private Abs abs;

  @Before
  public void setUp() throws Exception
  {
    abs=new Abs("", Optional.empty());
  }

  @Test
  public void testEvaluate() throws Exception
  {
    final Stack<Token<?>> values=new Stack<>();
    values.push(new Value(-11));

    abs.evaluate(values);

    assertThat(values).hasSize(1);
    assertThat(values.pop().getValue()).isEqualTo(11d);
  }

  @Test(expected=NotEnoughOperands.class)
  public void testNotEnoughData() throws Exception
  {
    final Stack<Token<?>> values=new Stack<>();
    abs.evaluate(values);
  }
}