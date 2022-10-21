package github.duanyuepeng.unisales.sales.quote.inbound;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InitialQuote {
  private String name;
  private String expirationTime;
  private String description;
}
