package com.eurogo.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
	@JsonProperty(required = true,value="dep_sid")
	Integer departureStationId;
	@JsonProperty(required = true,value="arr_sid")
	Integer arrivalStationId;
	@JsonProperty(required = true,value="direct_bus_route")
	boolean directBusRoute;
	public Integer getDepartureStationId() {
		return departureStationId;
	}
	public void setDepartureStationId(Integer departureStationId) {
		this.departureStationId = departureStationId;
	}
	public Integer getArrivalStationId() {
		return arrivalStationId;
	}
	public void setArrivalStationId(Integer arrivalStationId) {
		this.arrivalStationId = arrivalStationId;
	}
	public boolean isDirectBusRoute() {
		return directBusRoute;
	}
	public void setDirectBusRoute(boolean directBusRoute) {
		this.directBusRoute = directBusRoute;
	}
	
}
