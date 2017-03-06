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
			while ((line = br.readLine()) != null) {
				String[] values=line.split(" ");
				buildGraph(values);
			}
		}
		return graph;
	}
	private static void buildGraph(String[] values) throws VertexNotFoundException {
		for(int i=1;i<values.length;i++){
			graph.addVertex(Integer.parseInt(values[i]));
		}
		for(int i=1;i<values.length;i++){
			if(i!=values.length-1){
				graph.addEdge(Integer.parseInt(values[i]),Integer.parseInt(values[i+1]));
			}
			if(i!=1){
				graph.addEdge(Integer.parseInt(values[i]),Integer.parseInt(values[i-1]));
			}
		}
	}
}
