package com.countryTest;

import common.Endpoint;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;

public class Language {
     /*
      Created on 08/11/18
     */
        @Test
      public void testStatusCode(){
        given().
        get(Endpoint.GET_LANG).then().statusCode(200);
        }

        @Test
      public void testIncorrectStatusCode() {
         given().
         get(Endpoint.GET_LANG_invalid).then().statusCode(404);
        }

        /*
        Search by the language Code
        */
        @Test
      public void searchByCode(){
         given()
         .pathParam("iso639_1", "et")
         .when()
         .get("https://restcountries.eu/rest/v2/lang/{iso639_1}")
         .then()
         .body("name",contains("Estonia"));
        }


}
