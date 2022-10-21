package github.duanyuepeng.unisales.sales.utils;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.InternalServerErrorException;

@Slf4j
public class UniRunnableUtils {
  public static void runSafely(UniSafeRunnable runnable) {
    try {
      runnable.run();
    } catch (Exception e) {
      throw new InternalServerErrorException(e);
    }
  }
}
