package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.types.Token;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryOperationTokenProducerTest
{
  private TokenProducer producer;

  @Before
  public void setUp() throws Exception
  {
    producer=BinaryOperationTokenProducer.getInstance();
  }

  @Test
  public void testOperationTokenProducerPlus() throws Exception {
    final String expression = "+6.23";
    final Token<?> t=producer.tryProduceToken(expression, Optional.empty()).get();

    assertThat(t.getValue()).isEqualTo("+");
    assertThat(t.getRemainigExpression()).isEqualTo("6.23");
  }

  @Test
  public void testOperationTokenProducerMinus() throws Exception {
    final String expression = "-6.23";
    final Token<?> t=producer.tryProduceToken(expression, Optional.empty()).get();

    assertThat(t.getValue()).isEqualTo("-");
    assertThat(t.getRemainigExpression()).isEqualTo("6.23");
  }

  @Test
  public void testOperationTokenProducerDiv() throws Exception {
    final String expression = "/6.23";
    final Token<?> t=producer.tryProduceToken(expression, Optional.empty()).get();

    assertThat(t.getValue()).isEqualTo("/");
    assertThat(t.getRemainigExpression()).isEqualTo("6.23");
  }

  @Test
  public void testOperationTokenProducerMul() throws Exception {
    final String expression = "*6.23";
    final Token<?> information=producer.tryProduceToken(expression, Optional.empty()).get();

    assertThat(information.getValue()).isEqualTo("*");
    assertThat(information.getRemainigExpression()).isEqualTo("6.23");
  }

  @Test
  public void testOperationTokenProducerPow() throws Exception {
    final String expression = "^6.23";
    final Token<?> information=producer.tryProduceToken(expression, Optional.empty()).get();

    assertThat(information.getValue()).isEqualTo("^");
    assertThat(information.getRemainigExpression()).isEqualTo("6.23");
  }
}