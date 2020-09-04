package com.irctc.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.domain.Train;
import com.irctc.repository.TrainRepository;

@Service
public class TrainService {

	@Autowired TrainRepository trainRepository;
	
	public Train addTrain(@Valid Train tReqst) {
		
		return trainRepository.save(tReqst);
	}

	public List<Train> getAllTrain() {
		
		return trainRepository.findAll();
	}

	public Optional<Train> getTrainById(String trainId) {
		
		return trainRepository.findById(Long.parseLong(trainId));
	}

}
