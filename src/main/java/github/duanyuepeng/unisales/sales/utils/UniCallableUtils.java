package github.duanyuepeng.unisales.sales.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
public class UniCallableUtils {
  public static <T> T callSafely(Callable<T> callable, T defaultValue) {
    T result = defaultValue;

    try {
      result = callable.call();
    } catch (Exception e) {
      log.error("Something bad happened!", e);
    }

    return result;
  }
}
