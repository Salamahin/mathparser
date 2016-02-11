package com.company.home.mathparser.token;

import com.company.home.mathparser.token.types.ExpressionToken;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class TokenizerTest
{

  private Tokenizer tokenizer;

  @Before
  public void setUp() throws Exception
  {
    tokenizer = new Tokenizer();
  }

  private List<String> toStringList(final List<ExpressionToken<?>> l) {
    return l.stream()
        .map(Object::toString)
        .collect(toList());
  }

  @Test
  public void canTokenize() throws Exception {
    final String expression="-2.25*(3+63)";
    final List<String> expectedTokens=Lists.newArrayList("-2.25", "*", "(", "3.0", "+", "63.0", ")");
    assertThat(toStringList(tokenizer.tokenize(expression))).isEqualTo(expectedTokens);
  }

  @Test
  public void testCanTokenize2() throws Exception
  {
    final String expression = "--2.25*(3+-5)";
    final List<String> expectedTokens = Lists.newArrayList("-", "-2.25", "*", "(", "3.0", "+", "-5.0", ")");
    assertThat(toStringList(tokenizer.tokenize(expression))).isEqualTo(expectedTokens);
  }
}