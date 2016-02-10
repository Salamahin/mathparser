package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.TokenInformation;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValueTokenProducerTest
{

  private ValueTokenProducer producer;

  @Before
  public void setUp() throws Exception
  {
    producer=new ValueTokenProducer();
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