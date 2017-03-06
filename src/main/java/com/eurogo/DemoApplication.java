package com.eurogo;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.eurogo.util.DataLoader;
import com.eurogo.util.VertexNotFoundException;

@SpringBootApplication
public class DemoApplication{
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		try{
			DataLoader.loadData(args[0]);
			
		} catch (IOException | NumberFormatException | VertexNotFoundException e) {
			e.printStackTrace();
		}
	}
}
