package com.eurogo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.eurogo.util.DataLoader;

@Service
public class RouteService {
	public boolean isRouteExists(int source,int dest) {
		List<Integer> path = DataLoader.graph.shortestPath(source,dest);
		if(path!=null && !path.isEmpty()){
			return true;
		}
		return false;
	}
}
