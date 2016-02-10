package com.company.home.mathparser;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenProducerTest
{
  @Test
  public void testNumberTokenProducer() throws Exception
  {
    final TokenProducer tp = new TokenProducer.NumberTokenProducer();

    final String expression = "2.52+6";
    final Token expected = new Token(expression, 3, tp);

    assertThat(tp.tryProduceToken(expression).get()).isEqualTo(expected);
  }

  @Test
  public void testOperationTokenProducer1() throws Exception {
    final TokenProducer tp = new TokenProducer.OperationTokenProducer();

    final String expression = "+6.23";
    final Token expected = new Token(expression, 0, tp);

    assertThat(tp.tryProduceToken(expression).get()).isEqualTo(expected);
  }

  @Test
  public void testOperationTokenProducer2() throws Exception {
    final TokenProducer tp = new TokenProducer.OperationTokenProducer();

    final String expression = "-6.23";
    final Token expected = new Token(expression, 0, tp);

    assertThat(tp.tryProduceToken(expression).get()).isEqualTo(expected);
  }

  @Test
  public void testOperationTokenProducer3() throws Exception {
    final TokenProducer tp = new TokenProducer.OperationTokenProducer();

    final String expression = "/6.23";
    final Token expected = new Token(expression, 0, tp);

    assertThat(tp.tryProduceToken(expression).get()).isEqualTo(expected);
  }

  @Test
  public void testOperationTokenProducer4() throws Exception {
    final TokenProducer tp = new TokenProducer.OperationTokenProducer();

    final String expression = "*6.23";
    final Token expected = new Token(expression, 0, tp);

    assertThat(tp.tryProduceToken(expression).get()).isEqualTo(expected);
  }
}