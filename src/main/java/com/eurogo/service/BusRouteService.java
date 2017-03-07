package com.eurogo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.eurogo.util.DataLoader;

@Service
public class BusRouteService {
	public boolean isRouteExists(int source,int dest) {
		List<Integer> path = DataLoader.getInstance().graph.shortestPath(source,dest);
		if(path!=null && !path.isEmpty()){
			return true;
		}
		return false;
	}
}
