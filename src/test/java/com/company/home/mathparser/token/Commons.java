package com.company.home.mathparser.token;

import java.util.List;

import static java.util.stream.Collectors.toList;

final class Commons
{
  private Commons()
  {
    throw new AssertionError();
  }

  static List<String> toListOfString(final List<?> list)
  {
    return list.stream()
        .map(Object::toString)
        .collect(toList());
  }
}
