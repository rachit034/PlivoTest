package plivo.com.test.api;

import java.util.HashMap;

import org.json.JSONObject;

import plivo.com.test.pojo.MessagePojo;

public class Message {
	
	
	
	public String getRequestBody(String[] data) throws Exception{
		
		MessagePojo message = new MessagePojo();
		message.setSrc(data[1]);
		message.setDst(data[2]);
		message.setText(data[3]);
		
		return new JSONObject(message).toString();
		
	}
	
	public HashMap<String,String> getHeaders(){
	
		HashMap<String,String> header = new HashMap<String,String>();
	     // header.put("Authorization"," Basic MWU3Zjg4OWIzOGQ4ZjA0MDdiZGI3ZWEzYjA5Y2Qy=");
	      header.put("Content-Type", "application/json");
	      
	      return header;
	}

}
