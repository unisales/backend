package github.duanyuepeng;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static github.duanyuepeng.objectmother.InitialQuoteMother.createSimpleQuote;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;

@QuarkusTest
public class QuoteResourceTest {

  @Test
  public void testCreateQuote() {
    String location = given()
      .header("Content-Type", "application/json")
      .body(createSimpleQuote())
      .when().post("/api/quotes")
      .then()
      .statusCode(201)
      .extract().header("Location");

    when().get(location)
      .then()
      .statusCode(200)
      .body("name", not(emptyString()));
  }

  @Test
  public void testQueryQuotes() {
    when().get("/api/quotes")
      .then().statusCode(200);
  }
}
