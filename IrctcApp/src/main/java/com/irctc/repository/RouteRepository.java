package com.irctc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irctc.domain.RouteHdr;

public interface RouteRepository extends JpaRepository<RouteHdr, Integer>{

	List<RouteHdr> findByStartStationAndEndStation(String startStation,String endStation);
}
