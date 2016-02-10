package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.Token;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTokenProducerTest
{

  private NumberTokenProducer producer;

  @Before
  public void setUp() throws Exception
  {
    producer=new NumberTokenProducer();
  }

  @Test
  public void testNumberTokenProducerNormal() throws Exception
  {
    final String expression = "2.52+6";
    final Token expected = new Token(expression, 3);

    assertThat(producer.tryProduceToken(expression).get()).isEqualTo(expected);
  }

  @Test
  public void testNumberTokenProducerFail() throws Exception
  {
    final String expression = "(2.52)";

    assertThat(producer.tryProduceToken(expression).isPresent()).isFalse();
  }
}