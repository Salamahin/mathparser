package com.company.home.mathparser.token.producers;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class FunctionTokenProducerTest {
    private TokenProducer producer;

    @Before
    public void setUp() throws Exception
    {
        producer=FunctionTokenProducer.getInstance();
    }

    @Test
    public void testOperationTokenProducerAbs() throws Exception {
        final String expression = "abs(-6.23)";
        final TokenInformation information=producer.tryProduceToken(expression).get();

        assertThat(information.getTokenValue().getValue()).isEqualTo("abs");
        assertThat(information.getRemainingExpression()).isEqualTo("(-6.23)");
    }

    @Test
    public void testOperationTokenProducerMax() throws Exception {
        final String expression = "max(-6.23)";
        final TokenInformation information=producer.tryProduceToken(expression).get();

        assertThat(information.getTokenValue().getValue()).isEqualTo("max");
        assertThat(information.getRemainingExpression()).isEqualTo("(-6.23)");
    }

    @Test
    public void testOperationTokenProducerFuncSep() throws Exception {
        final String expression = ",-6.23";
        final TokenInformation information=producer.tryProduceToken(expression).get();

        assertThat(information.getTokenValue().getValue()).isEqualTo(",");
        assertThat(information.getRemainingExpression()).isEqualTo("-6.23");
    }

}