package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.TokenInformation;
import org.junit.Before;
import org.junit.Test;

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
    final TokenInformation information=producer.tryProduceToken(expression).get();

    assertThat(information.getTokenValue().getValue()).isEqualTo("(");
    assertThat(information.getRemainingExpression()).isEqualTo("234)");
  }

  @Test
  public void testClosedParenthesisTokenProducer() throws Exception {

    final String expression = ")233";
    final TokenInformation information=producer.tryProduceToken(expression).get();

    assertThat(information.getTokenValue().getValue()).isEqualTo(")");
    assertThat(information.getRemainingExpression()).isEqualTo("233");
  }
}