package github.duanyuepeng.unisales.sales.utils.errors;

import github.duanyuepeng.unisales.sales.utils.messages.AppMessages;
import io.quarkus.qute.i18n.MessageBundles;

import javax.ws.rs.BadRequestException;

public class BadRequestExceptions {
  public static BadRequestException invalidRhsColonError(String value) {
    return new BadRequestException(MessageBundles.get(AppMessages.class).invalidRhsColonError(value));
  }
}
