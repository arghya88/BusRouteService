package com.eurogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.eurogo.service.RouteService;
import com.eurogo.util.Response;

@RestController
@RequestMapping("api/direct")
public class RouteController {
	@Autowired
	private RouteService routeService;
	//http://localhost:8080/api/direct?dep_sid={}&arr_sid={}
	@RequestMapping(method=RequestMethod.GET,produces = "application/json")
	public ResponseEntity<Response> getRoute(@RequestParam("dep_sid") int departure,@RequestParam("arr_sid") int arrival){
		Response response=new Response();
		response.setDep_sid(departure);
		response.setArr_sid(arrival);
		response.setDirect_bus_route(false);
		try {
			boolean result=routeService.isRouteExists(departure,arrival);
			if(result){
				response.setDirect_bus_route(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
