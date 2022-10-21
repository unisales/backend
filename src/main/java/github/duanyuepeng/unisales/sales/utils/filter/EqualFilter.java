package github.duanyuepeng.unisales.sales.utils.filter;

import lombok.RequiredArgsConstructor;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map;

import static github.duanyuepeng.unisales.sales.utils.filter.UniHqlUtils.createHqlVarName;
import static github.duanyuepeng.unisales.sales.utils.filter.UniHqlUtils.createHqlVarRef;

@RequiredArgsConstructor
public class EqualFilter implements RhsColonFilter {
  private final String field;
  private final Object value;

  @Override
  public String toHqlQuery(int i) {
    return field + " = " + createHqlVarRef(field, i);
  }

  @Override
  public Map.Entry<String, Object> toParameter(int i) {
    return new SimpleImmutableEntry<>(createHqlVarName(field, i), value);
  }
}
