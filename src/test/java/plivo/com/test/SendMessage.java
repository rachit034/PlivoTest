package plivo.com.test;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.path.json.JsonPath;

import plivo.com.test.api.Message;
import plivo.com.test.utils.MessageLogs;
import plivo.com.test.utils.Utils;

/**
 * Unit test for simple App.
 */
public class SendMessage extends Utils {

	Message msg;
	Utils util = new Utils();
	String endpoint =  "/Message/";
	MessageLogs messageLogsObj;

	@Test(dataProvider = "getData")
	public void sendMessageTest(String... data) throws Exception {
		messageLogsObj = new MessageLogs();

		msg = new Message();
		HashMap<String, String> headers = msg.getHeaders();
		String body = msg.getRequestBody(data);
		String response = util.postRequest(body, headers, endpoint);
		System.out.println(response);
		JsonPath json = new JsonPath(response);
		//Storing the message udid along with sender and reciever
		List<String> msg_udid = json.get("message_uuid");
		messageLogsObj.setSource(data[1]);
		messageLogsObj.setDestination(data[2]);
		messageLogsObj.setMessage(data[3]);
		messageLogsObj.setUdid(msg_udid.get(0));
		messageLogs.put(data[0], messageLogsObj);
		
		
		
//		Either getmessage API can be called here 
//		GetMessage getmessage = new GetMessage();
//		getmessage.getMessageTest(new String[]{data[0],"Sent"});

	}

	@DataProvider
	public Object[][] getData() {
		// [0] source
		// [1] receiver
		// [2] message
		Object[][] obj = new Object[][] { { "TCID_01", "+1 432-239-1334", "+1 757-300-5064", "hello rachit!!!" }, };
		return obj;
	}

}
