package com.company.home.mathparser.token;

import com.company.home.mathparser.token.types.Minus;
import com.company.home.mathparser.token.types.Token;
import com.company.home.mathparser.token.types.UnaryMinus;
import com.company.home.mathparser.token.types.Value;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenCandidatesSelectorTest
{

  private TokenCandidatesSelector selector;

  @Before
  public void setUp() throws Exception
  {
    selector=new TokenCandidatesSelector();
  }

  @Test
  public void testWouldPreferValueOverUnaryMinus() throws Exception
  {
    final UnaryMinus unaryMinus=new UnaryMinus("", Optional.empty());
    final Value value=new Value(-3, "", Optional.empty());

    final List<Token<?>> l=Lists.newArrayList(unaryMinus, value);
    final Optional<Token<?>> token=selector.select(l);

    assertThat(token.get()).isInstanceOf(Value.class);
    assertThat(token.get()).isEqualTo(value);
  }

  @Test
  public void testHasNoAffect() throws Exception
  {
    final UnaryMinus unaryMinus=new UnaryMinus("", Optional.empty());
    final Minus binaryMinus=new Minus("", Optional.empty());

    final List<Token<?>> l=Lists.newArrayList(unaryMinus, binaryMinus);
    final Optional<Token<?>> token=selector.select(l);

    assertThat(token.get()).isInstanceOf(UnaryMinus.class);
    assertThat(token.get()).isEqualTo(unaryMinus);
  }

}