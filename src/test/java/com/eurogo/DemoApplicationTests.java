package com.eurogo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.eurogo.util.Graph;
import com.eurogo.util.VertexNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test 
	public void testGraphHasPathBetweenVertex() throws VertexNotFoundException{
		Graph<Integer> graph=new Graph<>();
		graph.addVertex(0);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		
		graph.addVertex(3);
		graph.addVertex(1);
		graph.addVertex(6);
		graph.addVertex(5);
		
		graph.addVertex(0);
		graph.addVertex(6);
		graph.addVertex(4);
		
		graph.addEdge(0,1);
		graph.addEdge(1,2);
		graph.addEdge(2,3);
		graph.addEdge(3,4);
		
		graph.addEdge(3,1);
		graph.addEdge(1,6);
		graph.addEdge(6,5);
		
		graph.addEdge(0,6);
		graph.addEdge(6,4);
		
		assertFalse(graph.shortestPath(3,6).isEmpty());
		assertNull(graph.shortestPath(6,3));
	}
}
