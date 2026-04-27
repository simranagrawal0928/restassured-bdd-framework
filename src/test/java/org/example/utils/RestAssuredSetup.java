package org.example.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

public class RestAssuredSetup {

    public static void init(){
        RestAssured.baseURI = ConfigReader.getBaseUrl().trim();
    }

    public static RequestSpecification getSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getBaseUrl())
                .setContentType(ContentType.JSON)
                .build();
    }


}
