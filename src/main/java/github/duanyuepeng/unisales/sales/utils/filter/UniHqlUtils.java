package github.duanyuepeng.unisales.sales.utils.filter;

import java.util.*;

public class UniHqlUtils {
  @SafeVarargs
  public static UniHql createHql(Collection<RhsColonFilter>... filtersGroups) {
    List<String> queries = new LinkedList<>();
    Map<String, Object> parameters = new HashMap<>();

    for (var filterGroup : filtersGroups) {
      int i = 1;
      for (var filter : filterGroup) {
        queries.add(filter.toHqlQuery(i));
        var parameter = filter.toParameter(i);
        parameters.put(parameter.getKey(), parameter.getValue());
        i++;
      }
    }

    String query = String.join(" and ", queries);
    return new UniHql(query, parameters);
  }

  static String createHqlVarRef(String field, int i) {
    return ":" + createHqlVarName(field, i);
  }

  static String createHqlVarName(String field, int i) {
    return field + "_" + i;
  }
}
