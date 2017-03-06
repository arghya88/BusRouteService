package com.eurogo.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
	@JsonProperty(required = true)
	Integer dep_sid;
	@JsonProperty(required = true)
	Integer arr_sid;
	@JsonProperty(required = true)
	boolean direct_bus_route;
	public Integer getDep_sid() {
		return dep_sid;
	}
	public void setDep_sid(Integer dep_sid) {
		this.dep_sid = dep_sid;
	}
	public Integer getArr_sid() {
		return arr_sid;
	}
	public void setArr_sid(Integer arr_sid) {
		this.arr_sid = arr_sid;
	}
	public boolean isDirect_bus_route() {
		return direct_bus_route;
	}
	public void setDirect_bus_route(boolean direct_bus_route) {
		this.direct_bus_route = direct_bus_route;
	}
	
}
