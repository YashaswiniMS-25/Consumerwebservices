package com.wolken.wolkenapp.ConsumerWebservice.dto;



import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GetResponse {
	private int id;
	private String type;
	private int noOfWheels;
	private String color;
	

}
