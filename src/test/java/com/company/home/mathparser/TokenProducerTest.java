package com.company.home.mathparser;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenProducerTest
{
  @Test
  public void testNumberTokenProducer() throws Exception
  {
    final String expression = "2.52+6";
    final Token expected = new Token(expression, 3);

    TokenProducer tp = new TokenProducer.NumberTokenProducer();
    assertThat(tp.tryProduceToken(expression).get()).isEqualTo(expected);
  }

  @Test
  public void testOperationTokenProducer1() throws Exception {
    final String expression = "+6.23";
    final Token expected = new Token(expression, 0);

    TokenProducer tp = new TokenProducer.OperationTokenProducer();
    assertThat(tp.tryProduceToken(expression).get()).isEqualTo(expected);
  }
}