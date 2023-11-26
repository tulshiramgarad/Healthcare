package com.hms.api.controller;

//Java Program to Create Rest Controller that

//Defines various API for Sending Mail

//Importing required classes

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.api.model.EmailDetails;
import com.hms.api.service.EmailPasswordService;

//Annotation
@RestController
@RequestMapping(value = "/email")
public class EmailController {

	@Autowired
	private EmailPasswordService emailPasswordService;

	// Sending a simple Email
	@PostMapping("/sendMail")
	public boolean sendMail(@RequestBody EmailDetails details) {
		boolean status = emailPasswordService.sendMail(details);

		return status;
	}
	
	@GetMapping(value = "/send-otp/{userId}")
	public ResponseEntity<String> sendOtp(@PathVariable String userId){
		String message = emailPasswordService.sendOtp(userId);
		System.out.println(message);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	
	

}
