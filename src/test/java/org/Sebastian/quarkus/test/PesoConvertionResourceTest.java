package org.Sebastian.quarkus.test;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PesoConvertionResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/peso-to-dolar/convertion/1100")
          .then()
             .statusCode(200)
             .body(is("$1.000"));
    }
}