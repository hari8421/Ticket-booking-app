package com.irctc.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="train_dtl")
public class Train {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TRAIN_ID")
	private long trainId;
	@Column(name="TRAIN_CODE")
	private String trainCode;
	@Column(name="TRAIN_NAME")
	private String trainName;
	@Column(name="DEPARTURE")
	private String departure;
	@Column(name="ARRIVAL")
	private String arrival;
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "trainEntity")
	 private List<RouteDtl> reEntity;
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public long getTrainId() {
		return trainId;
	}
	public void setTrainId(long trainId) {
		this.trainId = trainId;
	}
	public String getTrainCode() {
		return trainCode;
	}
	public void setTrainCode(String trainCode) {
		this.trainCode = trainCode;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	
	
	
	

}
