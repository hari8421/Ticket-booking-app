package com.irctc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.irctc.domain.RouteDtl;
@Transactional
public interface RouteDtlRepository extends JpaRepository<RouteDtl, Long>{
	@Modifying
	@Query("UPDATE RouteDtl r SET r.fare = :fare WHERE r.routeDtlId = :routeDtlId")
	int updateFare(@Param("fare") String fare,@Param("routeDtlId") long routeDtlId);
}
