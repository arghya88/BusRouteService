package com.eurogo;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.eurogo.exception.VertexNotFoundException;
import com.eurogo.util.DataLoader;

@SpringBootApplication
public class BusRouteApplication{
	private static final Logger log = LoggerFactory.getLogger(BusRouteApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BusRouteApplication.class, args);
		try{
			DataLoader.getInstance().loadData(args[0]);
			
		} catch (IOException | VertexNotFoundException e) {
			log.error("Exception occured :",e);
		}
	}
}
