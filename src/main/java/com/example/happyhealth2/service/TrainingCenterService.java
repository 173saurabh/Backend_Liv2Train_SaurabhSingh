package com.example.happyhealth2.service;

import java.util.List;

import com.example.happyhealth2.model.TrainingCenter;

public interface TrainingCenterService {

	TrainingCenter createTrainingCenter(TrainingCenter trainingCenter);

	List<TrainingCenter> getAllTrainingCenters();

}
