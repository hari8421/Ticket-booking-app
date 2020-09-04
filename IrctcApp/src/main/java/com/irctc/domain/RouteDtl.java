package com.irctc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="route_dtl")
public class RouteDtl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ROUTE_DTL_ID")
	private long routeDtlId;
	
	@Column(name="TRAIN_ID")
	private long trainId;
	@Column(name="ROUTE_ID")
	private int routeId;
	
	@Column(name="FARE")
	private String fare;
	
	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}

	@ManyToOne
    @JoinColumn(name = "ROUTE_ID", nullable = false, updatable = false,insertable = false)
    private RouteHdr rhEntity;
	
	@ManyToOne
	  @JoinColumn(name = "TRAIN_ID", nullable = false, updatable = false,insertable =
	  false) private Train trainEntity;

	public long getRouteDtlId() {
		return routeDtlId;
	}

	public void setRouteDtlId(long routeDtlId) {
		this.routeDtlId = routeDtlId;
	}

	

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public long getTrainId() {
		return trainId;
	}

	public void setTrainId(long trainId) {
		this.trainId = trainId;
	}



	public Train getTrainEntity() {
		return trainEntity;
	}

	public void setTrainEntity(Train trainEntity) {
		this.trainEntity = trainEntity;
	}
	  
	  
	 
	
	

}
