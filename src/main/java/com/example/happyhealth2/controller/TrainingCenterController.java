package com.example.happyhealth2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.happyhealth2.model.TrainingCenter;
import com.example.happyhealth2.service.TrainingCenterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/trainingCenter")
@CrossOrigin
@Slf4j

public class TrainingCenterController 
{
	@Autowired
	TrainingCenterService trainingCenterService;
	
	@PostMapping(value = "/create-training-center")
	public ResponseEntity<Map<String,Object>> createTrainingCenter(@RequestBody TrainingCenter trainingCenter)
	{
		//System.out.println("........................" +trainingCenter);
		Map<String,Object> map=new HashMap<>();
		String msg="Fail";
		map.put("status",msg);
		TrainingCenter tc=trainingCenterService.createTrainingCenter(trainingCenter);
		
		if(tc!=null)
		{
			map.put("status","Success");
			map.put("TrainingCenter", tc);
		}
		
		return new ResponseEntity<>(map,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/get-all-training-centers")
	public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters()
	{
		List<TrainingCenter> list = trainingCenterService.getAllTrainingCenters();
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
}
