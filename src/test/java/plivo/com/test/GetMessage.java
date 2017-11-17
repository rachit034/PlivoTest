package plivo.com.test;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.path.json.JsonPath;

import plivo.com.test.utils.MessageLogs;
import plivo.com.test.utils.Utils;

public class GetMessage extends Utils{
	
	
	String authid = "MAY2U1YTY3OTVMNJFJZD";
	String endpoint = authid + "/Message/";
	Utils util = new Utils();
	
	
	@Test(dataProvider="getData")
	public void getMessageTest(String... data){
		
		HashMap<String,String> headers = new HashMap<String,String>();
		String response = util.getRequest(headers, endpoint  + messageLogs.get(data[0]).getUdid());
		JsonPath json = new JsonPath(response);
		Assert.assertEquals(json.get("message_state").toString().toLowerCase(), data[1].toLowerCase());
		
		
		
	}
	@DataProvider
	public Object[][] getData() {
		//obj[0] = TestCaseId same as used in SendMessageTest 
		//obj[1] = Expected value of message status
		Object[][] obj = new Object[][] { { "TCID_01","Sent"} };
		return obj;
	}

}
