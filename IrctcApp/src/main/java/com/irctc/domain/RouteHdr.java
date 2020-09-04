package com.irctc.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="route_hdr")
public class RouteHdr {
	
	@Autowired
	@Id
	@GeneratedValue(generator = "sequence-generator")
	 @GenericGenerator(
		      name = "sequence-generator",
		      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
		      parameters = {
		        @Parameter(name = "sequence_name", value = "route_sequence"),
		        @Parameter(name = "initial_value", value = "100"),
		        @Parameter(name = "increment_size", value = "1")
		        })
    
	@Column(name="ROUTE_ID")
	private int routeId;
	@Column(name="START_STATION")
	@NotEmpty(message =  "Start station can not be empty")
	@Pattern(regexp="^[A-Za-z]*$",message = "Start station can only contain alphabets")
	private String startStation;
	@NotEmpty(message =  "End station can not be empty")
	@Pattern(regexp="^[A-Za-z]*$",message = "Start station can only contain alphabets")
	@Column(name="END_STATION")
	private String endStation;
	
 
	 @OneToMany(mappedBy = "rhEntity")
	 private List<RouteDtl> reEntity;
	 
	 

	public List<RouteDtl> getReEntity() {
		return reEntity;
	}



	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public String getEndStation() {
		return endStation;
	}

	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}

	
	

}
