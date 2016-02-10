package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.Token;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class ClosedParenthesisTokenProducerTest
{
  private TokenProducer producer;

  @Before
  public void setUp() throws Exception
  {
    producer=new ClosedParenthesisTokenProducer();
  }

  @Test
  public void testOpenParenthesisTokenProducer() throws Exception {

    final String expression = ")233";
    final Token expected = new Token(expression, 0);

    assertThat(producer.tryProduceToken(expression).get()).isEqualTo(expected);
  }
}