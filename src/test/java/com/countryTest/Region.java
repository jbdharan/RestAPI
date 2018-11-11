package com.countryTest;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class Region {

    /*
    Verify the status code for the end point
     */
    @Test
    public void testStatusCode() {
        given()
        .pathParam("region", "asia")
        .when()
        .get("https://restcountries.eu/rest/v2/region/{region}")
        .then().statusCode(200)
        .log().all();
    }
    /*
    Finding the regions of countries
    */
    @Test
    public void ListOfRegions() {
        String baseURL = "http://restcountries.eu";
        String path = "/rest/v2/all";
        String url = baseURL + path;
        Response response = given().get(url).
                then().extract().response();
        System.out.println(response);
        ArrayList<String> region = response.path("region");
        ArrayList<String> country = response.path("name");
        ArrayList<String> translation = response.path("translations.ja");

        System.out.println("The region is " + region.size());

        for (int i = 0; i < region.size(); i++) {

            if (region.get(i).equals("Europe")) {
                String country_name = country.get(i);
                System.out.println("The country name is " + country_name);
            }


        }
    }
}
