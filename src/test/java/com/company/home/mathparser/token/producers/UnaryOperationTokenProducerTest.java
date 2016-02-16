package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.types.Token;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.StrictAssertions.assertThat;


public class UnaryOperationTokenProducerTest {
    private TokenProducer producer;

    @Before
    public void setUp() throws Exception
    {
        producer=new UnaryOperationTokenProducer();
    }

    @Test
    public void testOperationTokenProducerUnaryNul() throws Exception {
        final String expression = "-(6.23";
        final Token<?> t=producer.tryProduceToken(expression, Optional.empty()).get();

        assertThat(t.getValue()).isEqualTo("un-");
        assertThat(t.getRemainingExpression()).isEqualTo("(6.23");
    }
}