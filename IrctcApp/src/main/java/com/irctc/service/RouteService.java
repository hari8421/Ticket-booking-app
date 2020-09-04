package com.irctc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.domain.RouteDtl;
import com.irctc.domain.RouteHdr;
import com.irctc.repository.RouteDtlRepository;
import com.irctc.repository.RouteRepository;

@Service
public class RouteService {
	
@Autowired RouteRepository reRepository;
@Autowired RouteDtlRepository rdRepository;
	
	public RouteHdr addRoute(RouteHdr rReqst) {
		RouteHdr rh=reRepository.save(rReqst);
		for(RouteDtl rd:rReqst.getReEntity()) {
			rd.setRouteId(rh.getRouteId());
			rdRepository.save(rd);
		}
		return reRepository.findById(rh.getRouteId()).get();
	}

	public Optional<RouteHdr> getRouteById(int routeId) {
		return reRepository.findById(routeId);
	}

	public List<RouteHdr> getAllRoutes() {
		return reRepository.findAll();
	}

	public List<RouteHdr> getRouteByStation(String source, String destination) {
		
		return reRepository.findByStartStationAndEndStation(source,destination);
	}

	public RouteHdr updateRoute(int routeId,String source, String destination) {
		RouteHdr reEntity=reRepository.findById(routeId).get();
		reEntity.setEndStation(destination);
		reEntity.setStartStation(source);
		return reRepository.save(reEntity);
	}

	public String deletTrainFromRoute(String routeId) {
		rdRepository.deleteById(Long.parseLong(routeId));
		return "Deleted";
	}

	public String updateFare(String rdId, String newFare) {
		String msg="";
		int i=rdRepository.updateFare(newFare, Long.parseLong(rdId));
		if(i>0) {
			msg="Updated";
		}else {
			msg="Update failed";
		}
		return msg;
	}

}
