package com.eurogo.conroller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.eurogo.service.BusRouteService;
import com.jayway.restassured.http.ContentType;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BusRouteControllerIT {

	@MockBean
	private BusRouteService  busRouteService;
	@LocalServerPort
	int port;
	@Before
	public void setup() {
		given(this.busRouteService.
				isRouteExists(3, 6)
				).willReturn(true);
		given(this.busRouteService.
				isRouteExists(6, 3)
				).willReturn(false);
	}

	@Test
	public void testGetBusRouteTrue() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("dep_sid", "3");
		parameters.put("arr_sid", "6");

		given().
		port(port).
		accept(ContentType.JSON).
		parameters(parameters).        
		when().
		get("/api/direct").            
		then().
		statusCode(200).            
		body(                       
				"dep_sid", is(3),            
				"arr_sid", is(6),
				"direct_bus_route",is(true)
				);
	}
	@Test
	public void testGetBusRouteFalse() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("dep_sid", "6");
		parameters.put("arr_sid", "3");

		given().
		port(port).
		accept(ContentType.JSON).
		parameters(parameters).        
		when().
		get("/api/direct").            
		then().
		statusCode(200).            
		body(                       
				"dep_sid", is(6),            
				"arr_sid", is(3),
				"direct_bus_route",is(false)
				);
	}
}
