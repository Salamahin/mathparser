package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.TokenInformation;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryOperationTokenProducerTest
{
  private BinaryOperationTokenProducer producer;

  @Before
  public void setUp() throws Exception
  {
    producer=new BinaryOperationTokenProducer();
  }

  @Test
  public void testOperationTokenProducerPlus() throws Exception {
    final String expression = "+6.23";
    final TokenInformation information=producer.tryProduceToken(expression).get();

    assertThat(information.getTokenValue().getValue()).isEqualTo("+");
    assertThat(information.getRemainingExpression()).isEqualTo("6.23");
  }

  @Test
  public void testOperationTokenProducerMinus() throws Exception {
    final String expression = "-6.23";
    final TokenInformation information=producer.tryProduceToken(expression).get();

    assertThat(information.getTokenValue().getValue()).isEqualTo("-");
    assertThat(information.getRemainingExpression()).isEqualTo("6.23");
  }

  @Test
  public void testOperationTokenProducerDiv() throws Exception {
    final String expression = "/6.23";
    final TokenInformation information=producer.tryProduceToken(expression).get();

    assertThat(information.getTokenValue().getValue()).isEqualTo("/");
    assertThat(information.getRemainingExpression()).isEqualTo("6.23");
  }

  @Test
  public void testOperationTokenProducerMul() throws Exception {
    final String expression = "*6.23";
    final TokenInformation information=producer.tryProduceToken(expression).get();

    assertThat(information.getTokenValue().getValue()).isEqualTo("*");
    assertThat(information.getRemainingExpression()).isEqualTo("6.23");
  }

  @Test
  public void testOperationTokenProducerPow() throws Exception {
    final String expression = "^6.23";
    final TokenInformation information=producer.tryProduceToken(expression).get();

    assertThat(information.getTokenValue().getValue()).isEqualTo("^");
    assertThat(information.getRemainingExpression()).isEqualTo("6.23");
  }
}