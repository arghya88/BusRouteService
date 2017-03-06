package com.eurogo;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.eurogo.util.DataLoader;
import com.eurogo.util.VertexNotFoundException;

@SpringBootApplication
public class BusRouteApplication{
	public static void main(String[] args) {
		SpringApplication.run(BusRouteApplication.class, args);
		try{
			DataLoader.loadData(args[0]);
			
		} catch (IOException | NumberFormatException | VertexNotFoundException e) {
			e.printStackTrace();
		}
	}
}
