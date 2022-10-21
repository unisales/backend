package github.duanyuepeng.unisales.sales.utils.filter;

import github.duanyuepeng.unisales.sales.utils.errors.BadRequestExceptions;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

public interface RhsColonFilter {
  static RhsColonFilter createRhsColonFilter(String field, String rhsColon, Function<String, Object> valueConverter) {
    String[] parts = rhsColon.split(":");
    if (parts.length != 2) {
      throw BadRequestExceptions.invalidRhsColonError(rhsColon);
    }
    return new EqualFilter(field, valueConverter.apply(parts[1]));
  }

  static Collection<RhsColonFilter> createRhsColonFilters(String field, Collection<String> expressions) {
    return createRhsColonFilters(field, expressions, value -> value);
  }

  static Collection<RhsColonFilter> createRhsColonFilters(String field, Collection<String> expressions,
                                                          Function<String, Object> valueConverter) {
    return expressions.stream()
      .map(expression -> createRhsColonFilter(field, expression, valueConverter))
      .toList();
  }

  String toHqlQuery(int i);

  Map.Entry<String, Object> toParameter(int i);
}
