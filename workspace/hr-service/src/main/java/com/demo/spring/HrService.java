package com.demo.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;
import com.github.andrewoma.dexx.collection.ArrayList;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HrService {

	@Autowired
	RestTemplate rt;
	
	@HystrixCommand(fallbackMethod="getEmpDetailsFallback")
	public MessageWrapper<Emp> getEmpDetails(int id) {
		
	HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity req = new HttpEntity<>(headers);

		ResponseEntity<Emp> response = rt.exchange("http://emp-service/emp/find/" + id, HttpMethod.GET, req,
				Emp.class);

		return new MessageWrapper<Emp>(response.getBody(), "Emp Found");
	}

	@HystrixCommand(fallbackMethod="getEmpListFallback")
	public MessageWrapper<List<Emp>> getEmpList() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity req = new HttpEntity<>(headers);

		ResponseEntity<List<Emp>> response = 
				rt.exchange("http://emp-service/emp/list", HttpMethod.GET, req,
				new ParameterizedTypeReference<List<Emp>>() {
				});

		return new MessageWrapper<List<Emp>>(response.getBody(), "List Full");
	}
	
	public MessageWrapper<List<Emp>> getEmpListFallback(){
		
		return new MessageWrapper<List<Emp>>(null, "Service Not Available");
	}
	
	public MessageWrapper<Emp> getEmpDetailsFallback(int id) {
		return new MessageWrapper<Emp>(new Emp(), "Emp Service is Down now");
	}
}
