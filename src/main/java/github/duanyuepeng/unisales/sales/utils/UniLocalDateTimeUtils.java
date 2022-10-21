package github.duanyuepeng.unisales.sales.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

@Slf4j
public class UniLocalDateTimeUtils {

  public static LocalDateTime MAX = LocalDateTime.of(9999, 12, 31, 23, 59, 59);
  public static LocalDateTime MIN = LocalDateTime.of(1, 1, 1, 0, 0, 0);


  public static LocalDateTime parseZonedDateTime(String dateTime, LocalDateTime defaultValue) {
    LocalDateTime result = defaultValue;

    if (StringUtils.isNotEmpty(dateTime)) {
      try {
        result = ZonedDateTime.parse(dateTime)
          .withZoneSameInstant(ZoneId.of("UTC"))
          .toLocalDateTime();
      } catch (DateTimeParseException e) {
        log.warn("failed to parse date time {}, use {} as default", dateTime, defaultValue);
      }
    }

    return result;
  }
}
