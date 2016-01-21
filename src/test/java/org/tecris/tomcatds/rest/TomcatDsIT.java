package org.tecris.tomcatds.rest;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import com.jayway.restassured.RestAssured;

public class TomcatDsIT {

    @Test
    public void test() {

        String expectedBookName = "Cloud Atlas";
        String expectedFullName = "David Mitchell";
        RestAssured.baseURI = "http://127.0.0.1:8080/tomcat-ds/rest/book";

        get("/test").then().body("bookName", equalTo(expectedBookName)).body("fullName", equalTo(expectedFullName));
    }
    
}
