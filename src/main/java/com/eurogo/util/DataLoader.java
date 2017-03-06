package com.eurogo.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataLoader {

	public static Graph<Integer> graph=new Graph<>();
	public static  Graph<Integer> loadData(String fileName) throws FileNotFoundException, IOException, NumberFormatException, VertexNotFoundException{
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line = br.readLine();
			int noOfRoutes=Integer.parseInt(line);
			System.out.println("Total Number of Routes:"+noOfRoutes);
			while ((line = br.readLine()) != null) {
				String[] values=line.split(" ");
				for(int i=1;i<values.length;i++){
					graph.addVertex(Integer.parseInt(values[i]));
				}
				for(int i=1;i<values.length;i++){
					if(i!=values.length-1)
						graph.addEdge(Integer.parseInt(values[i]),Integer.parseInt(values[i+1]));
				}
			}
		}
		return graph;
	}
}
