package github.duanyuepeng.unisales.sales.quote.model;

import github.duanyuepeng.unisales.sales.quote.inbound.InitialQuote;
import github.duanyuepeng.unisales.sales.utils.UniEntity;
import github.duanyuepeng.unisales.sales.utils.UniLocalDateTimeUtils;
import github.duanyuepeng.unisales.sales.utils.UniNoneNullBeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static github.duanyuepeng.unisales.sales.utils.UniLocalDateTimeUtils.parseZonedDateTime;

@Entity
public class Quote extends UniEntity {
  @Column(length = 63, nullable = false)
  public String name = "";
  @Column(nullable = false)
  public LocalDateTime expirationTime = UniLocalDateTimeUtils.MAX;
  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "enum('DRAFT','NEEDS_REVIEW','IN_REVIEW','APPROVED','REJECTED','PRESENTED','ACCEPTED','DENIED')")
  public QuoteStatus status = QuoteStatus.DRAFT;
  @Column(length = 63, nullable = false)
  public String description = "";
  @Column(precision = 10, scale = 2, nullable = false)
  public BigDecimal subtotal = BigDecimal.ZERO;
  @Column(precision = 10, scale = 2, nullable = false)
  public BigDecimal totalPrice = BigDecimal.ZERO;
  @Column(nullable = false)
  public LocalDateTime updateTime = UniLocalDateTimeUtils.MIN;

  public static Quote fromQuoteInput(InitialQuote input) {
    Quote quote = new Quote();

    // TBD: copy ignore null values
    UniNoneNullBeanUtils.copyProperties(quote, input);

    if (StringUtils.isNotEmpty(input.getExpirationTime())) {
      quote.expirationTime = parseZonedDateTime(input.getExpirationTime(), LocalDateTime.MAX);
    }

    return quote;
  }
}
