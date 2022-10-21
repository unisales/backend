package github.duanyuepeng.unisales.sales.utils.messages;

import io.quarkus.qute.i18n.Localized;
import io.quarkus.qute.i18n.Message;

@Localized("zh")
public interface ChineseAppMessages extends AppMessages {
  @Override
  @Message("无效的冒号分割表达式： \"{value}\".")
  String invalidRhsColonError(String value);
}
