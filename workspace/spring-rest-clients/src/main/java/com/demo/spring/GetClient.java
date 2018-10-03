package com.demo.spring;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Data;

public class GetClient {

	public static void main(String[] args) {
		String credentials="anil:welcome1";
		String encryptedCred=new String(Base64.encodeBase64(credentials.getBytes()));
	RestTemplate rt= new RestTemplate();
	
	HttpHeaders headers=new HttpHeaders();
	headers.set("Accept", "application/json");
	headers.set("Authorization", "Basic "+encryptedCred);
	
	HttpEntity req=new HttpEntity<>(headers);
	
	ResponseEntity<Data> response=
			rt.exchange("http://localhost:8080/emp/find/204", HttpMethod.GET, req, Data.class);
	System.out.println(response.getBody().getName());
	}

}
