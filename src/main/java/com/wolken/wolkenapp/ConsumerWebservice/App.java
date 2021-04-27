package com.wolken.wolkenapp.ConsumerWebservice;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.wolken.wolkenapp.ConsumerWebservice.dto.GetResponse;



/**
 * Hello world!
 *
 */
public class App 

{
    public static void main( String[] args )
    {
    	post();
    	//get();
    	//update();
    	//delete();
    	
    }
    static void get() {
    	Logger logger=Logger.getLogger("App");
    	logger.info("inside get");
    	
    	 RestTemplate restTemplate =new RestTemplate();
    	 logger.info("inside Resttemplate");
    	 
         HttpHeaders headers =new HttpHeaders();
         logger.info("headers object created");
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         logger.info("setAccept ");
         HttpEntity<GetResponse> entity=new HttpEntity<GetResponse>(headers);
         logger.info("entity created");
        ResponseEntity<Object[]> responseEntity=restTemplate.exchange("http://localhost:8080/garage/getAll",HttpMethod.GET,entity,Object[].class);
        logger.info("response entity created");
        Object[] objects=responseEntity.getBody();
        logger.info("object array created");
        //System.out.println(responseEntity.getBody());
         for(int i=0;i<objects.length;i++)
         System.out.println(objects[i]);
    }
    static void post() {
    	Logger logger=Logger.getLogger("App");
    	logger.info("inside Post");
    	RestTemplate resttemplate=new RestTemplate();
    	logger.info("resttemplate object created");
    	
    	GetResponse getresponse=new GetResponse();
    	logger.info("setting values");
    	
    	getresponse.setId(16);
    	logger.info("setting id");
    	getresponse.setColor("blue");
    	logger.info("setting color");
    	getresponse.setNoOfWheels(4);
    	logger.info("setting no of wheels");
    	getresponse.setType("car");
    	logger.info("setting type ");
    	
    	HttpHeaders headers=new HttpHeaders();
    	 logger.info("headers object created");
    	headers.setContentType(MediaType.APPLICATION_JSON);
    	 logger.info("setAccept ");
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	
    	HttpEntity<GetResponse> entity=new HttpEntity<GetResponse>(getresponse,headers);
    	 logger.info("entity created");
    	ResponseEntity responseEntity = resttemplate.exchange("http://localhost:8080/garage/save",
				HttpMethod.POST, entity, String.class);  
    	 logger.info("object array created");
    	System.out.println(responseEntity.getBody());
    	
    }
    static void update() {
    	Logger logger=Logger.getLogger("App");
    	logger.info("inside update method");
    	
    	RestTemplate restTemplate = new RestTemplate();
    	logger.info("resttemplate object created");

    	GetResponse getresponse = new GetResponse();
    	logger.info("setting values");
    	getresponse.setId(4);
    	logger.info("setting id");
		getresponse.setColor("blue");
		logger.info("setting color");
	
		HttpHeaders headers = new HttpHeaders();
		logger.info("headers object created");
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		logger.info("setAccept ");

		HttpEntity<GetResponse> entity = new HttpEntity<GetResponse>(getresponse, headers);
		logger.info("object array created");

		ResponseEntity responseEntity = restTemplate.exchange("http://localhost:8080/garage/update",
				HttpMethod.PUT, entity, String.class);
		
		logger.info("response object created");
		System.out.println(responseEntity.getBody());
    	
    }
    static void delete() {
    	Logger logger=Logger.getLogger("App");
    	logger.info("inside delete method");
    	
    	logger.info("resttemplate object created");
    	RestTemplate restTemplate = new RestTemplate();

    	logger.info("getresponse object");
    	GetResponse getresponse = new GetResponse();

    	logger.info("setting color");
		getresponse.setColor("blue");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		logger.info("httpentity object created");
		HttpEntity<GetResponse> entity = new HttpEntity<GetResponse>(getresponse, headers);

		ResponseEntity responseEntity = restTemplate.exchange("http://localhost:8080/garage/delete",
				HttpMethod.DELETE, entity, String.class);
		 logger.info("entity created");
		System.out.println(responseEntity.getBody());
    	
    }
    
}
