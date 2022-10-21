package github.duanyuepeng.actions;

import github.duanyuepeng.unisales.sales.quote.model.Quote;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import static github.duanyuepeng.objectmother.InitialQuoteMother.createSimpleQuote;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class QuoteActions {
  public static Quote createQuote() {
    String location = given()
      .header("Content-Type", "application/json")
      .body(createSimpleQuote())
      .when().post("/api/quotes")
      .then()
      .statusCode(201)
      .extract().header("Location");

    ExtractableResponse<Response> res = when().get(location)
      .then()
      .extract();

    return res.as(Quote.class);
  }
}
