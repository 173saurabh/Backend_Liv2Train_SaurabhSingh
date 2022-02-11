package com.example.happyhealth2.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.happyhealth2.dao.TrainingCenterDao;
import com.example.happyhealth2.model.TrainingCenter;
import com.example.happyhealth2.service.TrainingCenterService;

@Service
@Transactional
public class TrainingCenterServiceImpl implements TrainingCenterService
{

	@Autowired
	TrainingCenterDao trainingCenterDao;
	
	@Override
	public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) 
	{
		TrainingCenter tc = trainingCenterDao.save(trainingCenter);
		return tc;
	}

	@Override
	public List<TrainingCenter> getAllTrainingCenters() {
		return (List<TrainingCenter>) trainingCenterDao.findAll();
	}

}
