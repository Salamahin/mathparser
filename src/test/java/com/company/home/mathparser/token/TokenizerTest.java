package com.company.home.mathparser.token;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.company.home.mathparser.token.Commons.toListOfString;
import static org.assertj.core.api.Assertions.assertThat;

public class TokenizerTest {

    private Tokenizer tokenizer;

    @Before
    public void setUp() throws Exception {
        tokenizer = new Tokenizer();
    }

    @Test
    public void canTokenize1() throws Exception {
        final String expression = "-2.25 * (3 + 63)";
        final List<String> expectedTokens = Lists.newArrayList("-2.25", "*", "(", "3.0", "+", "63.0", ")");
        assertThat(toListOfString(tokenizer.tokenize(expression))).isEqualTo(expectedTokens);
    }

    @Test
    public void testCanTokenize2() throws Exception {
        final String expression = "--2.25 * (3 + -5)";
        final List<String> expectedTokens = Lists.newArrayList("un-", "-2.25", "*", "(", "3.0", "+", "-5.0", ")");
        assertThat(toListOfString(tokenizer.tokenize(expression))).isEqualTo(expectedTokens);
    }

    @Test
    public void testCanTokenize3() throws Exception {
        final String expression = "-(-(-5))";
        final List<String> expectedTokens = Lists.newArrayList("un-", "(", "un-", "(", "-5.0", ")", ")");
        assertThat(toListOfString(tokenizer.tokenize(expression))).isEqualTo(expectedTokens);
    }

    @Test
    public void testCanTokenize4() throws Exception {
        final String expression = "2 + abs(-5)";
        final List<String> expectedTokens = Lists.newArrayList("2.0", "+", "abs", "(", "-5.0", ")");
        assertThat(toListOfString(tokenizer.tokenize(expression))).isEqualTo(expectedTokens);
    }

    @Test
    public void testCanTokenize5() throws Exception {
        final String expression = "2 + max(-5, -3)";
        final List<String> expectedTokens = Lists.newArrayList("2.0", "+", "max", "(", "-5.0", ",", "-3.0", ")");
        assertThat(toListOfString(tokenizer.tokenize(expression))).isEqualTo(expectedTokens);
    }

    @Test(expected = UnrecognizedExpression.class)
    public void testInvalidExpression() throws Exception
    {
        final String expression="3.2 3.1";
        tokenizer.tokenize(expression);
    }
}