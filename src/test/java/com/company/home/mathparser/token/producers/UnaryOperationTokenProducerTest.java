package com.company.home.mathparser.token.producers;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;


public class UnaryOperationTokenProducerTest {
    private TokenProducer producer;

    @Before
    public void setUp() throws Exception
    {
        producer=UnaryOperationTokenProducer.getInstance();
    }

    @Test
    public void testOperationTokenProducerUnaryNul() throws Exception {
        final String expression = "-(6.23";
        final TokenInformation information=producer.tryProduceToken(expression).get();

        assertThat(information.getTokenValue().getValue()).isEqualTo("un-");
        assertThat(information.getRemainingExpression()).isEqualTo("(6.23");
    }
}