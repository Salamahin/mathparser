package com.company.home.mathparser.token.producers;

import org.junit.Before;
import org.junit.Test;

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
    final TokenInformation information=producer.tryProduceToken(expression).get();

    assertThat(information.getTokenValue().getValue()).isEqualTo(2.52);
    assertThat(information.getRemainingExpression()).isEqualTo("+6");
  }

  @Test
  public void testNumberTokenProducerFail() throws Exception
  {
    final String expression = "(2.52)";

    assertThat(producer.tryProduceToken(expression).isPresent()).isFalse();
  }
}