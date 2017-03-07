package com.eurogo.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.eurogo.exception.VertexNotFoundException;

public class DataLoader {

	public Graph<Integer> graph=new Graph<>();
	
	private DataLoader(){
		
	}
	private static class SingletonHelper{
        private static final DataLoader INSTANCE = new DataLoader();
    }
	public static DataLoader getInstance(){
        return SingletonHelper.INSTANCE;
    }
	public void loadData(String fileName) throws IOException, VertexNotFoundException{
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] values=line.split(" ");
				graph=buildGraph(values,graph);
			}
		}
	}
	Graph<Integer> buildGraph(String[] values,Graph<Integer> graph) throws VertexNotFoundException {
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
		return graph;
	}
}
