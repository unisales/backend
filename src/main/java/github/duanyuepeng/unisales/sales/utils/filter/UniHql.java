package github.duanyuepeng.unisales.sales.utils.filter;

import java.util.Map;

public record UniHql(String hql, Map<String, Object> parameters) {
}
