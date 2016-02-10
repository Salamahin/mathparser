package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.Token;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationTokenProducerTest
{
  private OperationTokenProducer producer;

  @Before
  public void setUp() throws Exception
  {
    producer=new OperationTokenProducer();
  }

  @Test
  public void testOperationTokenProducerPlus() throws Exception {
    final String expression = "+6.23";
    final Token expected = new Token(expression, 0);

    assertThat(producer.tryProduceToken(expression).get()).isEqualTo(expected);
  }

  @Test
  public void testOperationTokenProducerMinus() throws Exception {
    final String expression = "-6.23";
    final Token expected = new Token(expression, 0);

    assertThat(producer.tryProduceToken(expression).get()).isEqualTo(expected);
  }

  @Test
  public void testOperationTokenProducerDiv() throws Exception {
    final String expression = "/6.23";
    final Token expected = new Token(expression, 0);

    assertThat(producer.tryProduceToken(expression).get()).isEqualTo(expected);
  }

  @Test
  public void testOperationTokenProducerMul() throws Exception {
    final String expression = "*6.23";
    final Token expected = new Token(expression, 0);

    assertThat(producer.tryProduceToken(expression).get()).isEqualTo(expected);
  }
}