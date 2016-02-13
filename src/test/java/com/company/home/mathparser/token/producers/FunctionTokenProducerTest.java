package com.company.home.mathparser.token.producers;

import com.company.home.mathparser.token.types.Token;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

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
        final Token<?> t=producer.tryProduceToken(expression, Optional.empty()).get();

        assertThat(t.getValue()).isEqualTo("abs");
        assertThat(t.getRemainigExpression()).isEqualTo("(-6.23)");
    }

    @Test
    public void testOperationTokenProducerMax() throws Exception {
        final String expression = "max(-6.23)";
        final Token<?> t=producer.tryProduceToken(expression, Optional.empty()).get();

        assertThat(t.getValue()).isEqualTo("max");
        assertThat(t.getRemainigExpression()).isEqualTo("(-6.23)");
    }

    @Test
    public void testOperationTokenProducerFuncSep() throws Exception {
        final String expression = ",-6.23";
        final Token<?> t=producer.tryProduceToken(expression, Optional.empty()).get();

        assertThat(t.getValue()).isEqualTo(",");
        assertThat(t.getRemainigExpression()).isEqualTo("-6.23");
    }

}