package plivo.com.test.utils;

import static com.jayway.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.ini4j.Ini;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class Utils {

	public static final HashMap<String,MessageLogs> messageLogs = new HashMap<String,MessageLogs>();
	private final String authId="MAY2U1YTY3OTVMNJFJZD";
	private final String authToken="MWU3Zjg4OWIzOGQ4ZjA0MDdiZGI3ZWEzYjA5Y2Qy";
	public Utils(){
		RestAssured.baseURI="https://api.plivo.com/v1/Account/";
	}
	public String postRequest(String request, Map<String, String> headers, String endpoint) {

		Response post = given().relaxedHTTPSValidation().auth().basic(authId, authToken).headers(headers).body(request).when().post(authId+endpoint);

		String response = post.asString();

		return response;
	}
	
	public String getRequest(Map<String, String> headers,String endpoint) {

		Response get = given().relaxedHTTPSValidation().auth().basic(authId, authToken).headers(headers).when().get(authId+endpoint);

		String response = get.asString();

		return response;
	}
	
}
