package com.irctc.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.domain.RouteHdr;
import com.irctc.service.RouteService;


@RestController
@RequestMapping("/")
@Validated
public class RouteController {
	
	@Autowired
	RouteService rService;
	
	private static final Logger logger = LoggerFactory.getLogger(RouteController.class);
	
	@PostMapping("/routes")
	public ResponseEntity<RouteHdr>  addRoute(@RequestBody @Valid RouteHdr rReqst) {
		logger.info("addRoute started");
		RouteHdr rEntity= rService.addRoute(rReqst);
		return new ResponseEntity<RouteHdr>(rEntity,HttpStatus.CREATED);
	}
	
	@PostMapping("/updateRoute")
	public ResponseEntity<RouteHdr>  updateRoute(@RequestBody @Valid RouteHdr rReqst) {
		logger.error("updateRoute started");
		RouteHdr rEntity= rService.addRoute(rReqst);
		return new ResponseEntity<RouteHdr>(rEntity,HttpStatus.OK);
	}
	
	@GetMapping("/getAllRoutes")
	public ResponseEntity<List<RouteHdr>>  getAllRoutes() {
		List<RouteHdr> rList=rService.getAllRoutes();
		return new ResponseEntity<List<RouteHdr>>(rList,HttpStatus.OK);
	}
	
	@GetMapping("/routes/{routeId}")
	public ResponseEntity<Optional<RouteHdr>>  getRouteById(@PathVariable("routeId") @Size(min=3,message = "Enter a valid route ID") String routeId) {
		Optional<RouteHdr> sList=rService.getRouteById(Integer.parseInt(routeId));
		return new ResponseEntity<Optional<RouteHdr>>(sList,HttpStatus.OK);
	}
	
	@GetMapping("/routes/trains/{source}/{destination}")
	public ResponseEntity<List<RouteHdr>>  getRouteByStation(@PathVariable("source")  String source,@PathVariable("destination")  String destination) {
		List<RouteHdr> sList=rService.getRouteByStation(source,destination);
		return new ResponseEntity<List<RouteHdr>>(sList,HttpStatus.OK);
	}
	
	@PutMapping("/routes/{routeId}/{source}/{destination}")
	public ResponseEntity<RouteHdr>  updateRoute(@PathVariable("routeId") @Size(min=3,message = "Enter a valid route ID") String routeId,@PathVariable("source")  String source,@PathVariable("destination")  String destination) {
		RouteHdr sList=rService.updateRoute(Integer.parseInt(routeId),source,destination);
		return new ResponseEntity<RouteHdr>(sList,HttpStatus.OK);
	}
	
	@DeleteMapping("/routes/{routeDtlId}")
	public ResponseEntity<String>  deleteTrain(@PathVariable("routeDtlId") String routeId) {
		String response=rService.deletTrainFromRoute(routeId);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	@PutMapping("/trains/{routeDtlId}/{newFare}")
	public ResponseEntity<String>  updateFare(@PathVariable("routeDtlId")  String rdId,@PathVariable("newFare")  String newFare) {
		String retMsg=rService.updateFare(rdId,newFare);
		return new ResponseEntity<String>(retMsg,HttpStatus.OK);
	}

}
