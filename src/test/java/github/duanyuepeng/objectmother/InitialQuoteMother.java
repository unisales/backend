package github.duanyuepeng.objectmother;

import github.duanyuepeng.unisales.sales.quote.inbound.InitialQuote;
import org.apache.commons.lang3.RandomStringUtils;

public class InitialQuoteMother {
  public static InitialQuote createSimpleQuote() {
    return new InitialQuote(RandomStringUtils.randomAlphabetic(5), null, null);
  }
}
