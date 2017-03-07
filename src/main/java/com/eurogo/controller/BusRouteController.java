package com.eurogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.eurogo.service.BusRouteService;
import com.eurogo.util.Response;

@RestController
@RequestMapping("api/direct")
public class BusRouteController {
	@Autowired
	private BusRouteService routeService;
	//http://localhost:8088/api/direct?dep_sid={}&arr_sid={}
	@RequestMapping(method=RequestMethod.GET,produces = "application/json")
	public ResponseEntity<Response> getBusRoute(@RequestParam("dep_sid") int departure,@RequestParam("arr_sid") int arrival){
		Response response=new Response();
		response.setDepartureStationId(departure);
		response.setArrivalStationId(arrival);
		response.setDirectBusRoute(false);
		try {
			boolean result=routeService.isRouteExists(departure,arrival);
			if(result){
				response.setDirectBusRoute(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
