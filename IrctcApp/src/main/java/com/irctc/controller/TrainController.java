package com.irctc.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.domain.Train;
import com.irctc.dto.TrainDTO;
import com.irctc.service.TrainService;

@RestController
@RequestMapping("/")
public class TrainController {
	
	@Autowired
	TrainService tService;
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	private static final Logger logger = LoggerFactory.getLogger(TrainController.class);
	
	@PostMapping("/addTrain")
	public ResponseEntity<TrainDTO>  addTrain(@RequestBody @Valid TrainDTO tReqst) {
		logger.info("addTrain started");
		Train te=modelMapper.map(tReqst, Train.class);
		Train tEntity= tService.addTrain(te);
		return new ResponseEntity<TrainDTO>(modelMapper.map(tEntity, TrainDTO.class),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllTrain")
	public ResponseEntity<List<Train>>  getAllTrain() {
		List<Train> tList=tService.getAllTrain();
		return new ResponseEntity<List<Train>>(tList,HttpStatus.OK);
	}
	
	@GetMapping("/getTrainById/{trainId}")
	public ResponseEntity<Optional<Train>>  getTrainById(@PathVariable("trainId") String trainId) {
		Optional<Train> tList=tService.getTrainById(trainId);
		return new ResponseEntity<Optional<Train>>(tList,HttpStatus.OK);
	}

}