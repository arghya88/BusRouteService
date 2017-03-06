package com.eurogo;

import static org.junit.Assert.assertEquals;
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
public class BusRouteApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	public void testAddVertex(){
		Graph<Integer> graph=new Graph<>();
		assertTrue(graph.addVertex(0));
		assertFalse(graph.addVertex(0));
		assertTrue(graph.addVertex(1));
	}
	@Test
	public void testAddEdge() throws VertexNotFoundException{
		Graph<Integer> graph=new Graph<>();
		graph.addVertex(0);
		graph.addVertex(1);
		assertTrue(graph.addEdge(0, 1));
	}
	@Test(expected=VertexNotFoundException.class)
	public void testAddEdgeThrowsException() throws VertexNotFoundException{
		Graph<Integer> graph=new Graph<>();
		assertTrue(graph.addEdge(0, 1));
	}
	
	@Test
	public void testRemoveVertex() {
		Graph<Integer> graph=new Graph<>();
		graph.addVertex(0);
		assertTrue(graph.removeVertex(0));
		assertFalse(graph.removeVertex(1));
	}
	@Test
	public void testRemoveEdge() throws VertexNotFoundException{
		Graph<Integer> graph=new Graph<>();
		graph.addVertex(0);
		graph.addVertex(1);
		assertTrue(graph.addEdge(0, 1));
		assertTrue(graph.removeEdge(0,1));
	}
	@Test
	public void testVetexCount(){
		Graph<Integer> graph=new Graph<>();
		graph.addVertex(0);
		graph.addVertex(1);
		assertEquals(graph.vertexCount(),2);
	}
	@Test
	public void testEdgeCount() throws VertexNotFoundException{
		Graph<Integer> graph=new Graph<>();
		graph.addVertex(0);
		graph.addVertex(1);
		graph.addEdge(0, 1);
		assertEquals(graph.edgeCount(),1);
	}
	@Test
	public void testContainsVertex(){
		Graph<Integer> graph=new Graph<>();
		graph.addVertex(0);
		assertTrue(graph.containsVertex(0));
	}
	@Test
	public void testContainsEdge() throws VertexNotFoundException{
		Graph<Integer> graph=new Graph<>();
		graph.addVertex(0);
		graph.addVertex(1);
		graph.addEdge(0, 1);
		assertTrue(graph.containsEdge(0, 1));
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
