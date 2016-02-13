package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.types.Token;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ParenthesisTokenProducerTest
{

  private TokenProducer producer;

  @Before
  public void setUp() throws Exception
  {
    producer=ParenthesisTokenProducer.getInstance();
  }

  @Test
  public void testOpenParenthesisTokenProducer() throws Exception {

    final String expression = "(234)";
    final Token<?> t=producer.tryProduceToken(expression, Optional.empty()).get();

    assertThat(t.getValue()).isEqualTo("(");
    assertThat(t.getRemainigExpression()).isEqualTo("234)");
  }

  @Test
  public void testClosedParenthesisTokenProducer() throws Exception {

    final String expression = ")233";
    final Token<?> t=producer.tryProduceToken(expression, Optional.empty()).get();

    assertThat(t.getValue()).isEqualTo(")");
    assertThat(t.getRemainigExpression()).isEqualTo("233");
  }
}