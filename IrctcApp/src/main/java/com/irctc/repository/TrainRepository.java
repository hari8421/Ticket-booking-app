package com.irctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irctc.domain.Train;

public interface TrainRepository extends JpaRepository<Train, Long>{

}
