package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.types.Token;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ValueTokenProducerTest
{

  private TokenProducer producer;

  @Before
  public void setUp() throws Exception
  {
    producer=ValueTokenProducer.getInstance();
  }

  @Test
  public void testNumberTokenProducerNormal() throws Exception
  {
    final String expression = "2.52+6";
    final Token<?> t=producer.tryProduceToken(expression, Optional.empty()).get();

    assertThat(t.getValue()).isEqualTo(2.52);
    assertThat(t.getRemainigExpression()).isEqualTo("+6");
  }

  @Test
  public void testNumberTokenProducerFail() throws Exception
  {
    final String expression = "(2.52)";

    assertThat(producer.tryProduceToken(expression, Optional.empty()).isPresent()).isFalse();
  }
}