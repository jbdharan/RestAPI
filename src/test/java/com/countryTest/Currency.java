package com.countryTest;

import com.country.framework.base;
import com.jayway.restassured.response.Response;
import common.Endpoint;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;


//import io.restassured.response.Response;

public class Currency {
    /***
     Verifying the response status code 200 - SUCCESS
     ***/
    @Test
    public void testStatusCode() {
        given()
        .pathParam("code", "GBP")
        .when()
        .get("https://restcountries.eu/rest/v2/currency/{code}")
        .then().statusCode(200);
    }

    /***
     Verifying the response status code 404 - Not Found
     ***/
    @Test
    public void testIncorrectStatusCode() {
        given()
        .get(Endpoint.GET_CURRENCY_invalid).then().statusCode(404);
    }

    /***
     Verifying the correct currency British Pound returned for the given currency code GBP
     ***/
    @Test
    public void validateCurrencyCode() {
        given()
        .pathParam("code", "GBP")
        .when()
        .get("https://restcountries.eu/rest/v2/currency/{code}")
        .then()
        .body("currencies", hasItems("British pound"));
    }

    /***
     Verifying the correct currency INR returned for the given country India
     ***/
    @Test
    public void validateCurrency_for_given_country() {
        RequestSpecification requestSpecification = new base().getRequestSpecification();
        given().get(Endpoint.GET_COUNTRY).then().statusCode(200)
        .and().contentType(ContentType.JSON)
        .and().body("name", hasItem("India"))
        .and().body("find { d -> d.name == 'India' }.currencies", hasItem("INR"));
    }


    /***
     Verifying the correct currency Symbol returned for the given country India
     ***/
    @Test
    public void searchCurrencybyCode() {
        RequestSpecification requestSpecification = new base().getRequestSpecification();
        given().get(Endpoint.GET_COUNTRY).then().statusCode(200)
        .and().contentType(ContentType.JSON)
        .and().body("name", hasItem("Colombia"))
        .and().body("find { d -> d.name == 'Colombia' }.currencies", hasItem("COP"));
    }
    /***
     Verifying the correct currency Symbol returned for the given country India
     ***/

    @Test
    public void getRequestFindCapital() throws JSONException {

        //make get request to fetch capital of norway
        Response resp = get("http://restcountries.eu/rest/v2/name/norway");

        //Fetching response in JSON
        JSONArray jsonResponse = new JSONArray(resp.asString());

        //Fetching value of capital parameter
        String capital = jsonResponse.getJSONObject(0).getString("capital");

        //Asserting that capital of Norway is Oslo
        Assert.assertEquals(capital, "Oslo");
    }




    }