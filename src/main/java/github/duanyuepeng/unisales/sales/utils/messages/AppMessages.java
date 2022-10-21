package github.duanyuepeng.unisales.sales.utils.messages;

import io.quarkus.qute.i18n.Message;
import io.quarkus.qute.i18n.MessageBundle;

@MessageBundle
public interface AppMessages {
  @Message("Invalid RHC colon expression: \"{value}\".")
  String invalidRhsColonError(String value);
}
