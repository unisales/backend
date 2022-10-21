package github.duanyuepeng.unisales.sales.quote;

import github.duanyuepeng.unisales.sales.quote.inbound.InitialQuote;
import github.duanyuepeng.unisales.sales.quote.model.Quote;
import github.duanyuepeng.unisales.sales.quote.model.QuoteStatus;
import github.duanyuepeng.unisales.sales.utils.filter.UniHql;
import github.duanyuepeng.unisales.sales.utils.filter.UniHqlUtils;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.panache.common.Page;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.EnumUtils;
import org.jboss.resteasy.reactive.RestQuery;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

import static github.duanyuepeng.unisales.sales.quote.model.Quote.fromQuoteInput;
import static github.duanyuepeng.unisales.sales.utils.filter.RhsColonFilter.createRhsColonFilters;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

@Path("/api/quotes")
@ApplicationScoped
@RequiredArgsConstructor
public class QuoteResource {

  @GET
  public Uni<List<Quote>> getAll(@RestQuery Integer index,
                                 @RestQuery Integer size,
                                 @RestQuery List<String> statusValues) {
    UniHql hql = UniHqlUtils.createHql(
      createRhsColonFilters("status", statusValues,
        statusStr -> EnumUtils.getEnumIgnoreCase(QuoteStatus.class, statusStr)
      )
    );

    return Quote.find(hql.hql(), hql.parameters())
      .page(Page.of(defaultIfNull(index, 0), defaultIfNull(size, 100)))
      .list();
  }

  @GET
  @Path("/{id}")
  public Uni<Quote> getOne(Long id) {
    return Quote.findById(id);
  }

  @POST
  public Uni<Response> create(InitialQuote input) {
    Quote quote = fromQuoteInput(input);
    return Panache.<Quote>withTransaction(quote::persist)
      .onItem().transform(inserted -> Response.created(URI.create("/api/quotes/" + inserted.id)).build());
  }
}
