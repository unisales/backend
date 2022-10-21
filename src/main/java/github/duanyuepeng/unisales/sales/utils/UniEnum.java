package github.duanyuepeng.unisales.sales.utils;

import org.apache.commons.lang3.EnumUtils;

import java.util.stream.Collectors;

public class UniEnum {
  public static <E extends Enum<E>> String getEnumDefinition(Class<E> enumClass) {
    String values = EnumUtils.getEnumList(enumClass).stream().map(Enum::name)
      .map(name -> "'" + name + "'").collect(Collectors.joining(","));
    return "enum(" + values + ")";
  }
}
