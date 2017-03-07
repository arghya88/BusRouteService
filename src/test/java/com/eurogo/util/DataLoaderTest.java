package com.eurogo.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.eurogo.exception.VertexNotFoundException;

@RunWith(JUnit4.class)
public class DataLoaderTest {
	@Test
	public void testBuildGraph() throws VertexNotFoundException{
		Graph<Integer> graph=new Graph<>();
		DataLoader dataloader=DataLoader.getInstance();
		String[] line1={"0","0","1","2","3","4"};
		graph=dataloader.buildGraph(line1,graph);
		String[] line2={"1","3","1","6","4"};
		graph=dataloader.buildGraph(line2,graph);
		String[] line3={"2","0","6","5"};
		graph=dataloader.buildGraph(line3,graph);
		assertTrue("Vertex 0 exists", graph.containsVertex(0));
		assertTrue("Vertex 5 exists", graph.containsVertex(5));
		assertTrue("Vertex 6 exists", graph.containsVertex(6));
		assertTrue("Vertex 3 exists", graph.containsVertex(3));
		assertEquals(7,graph.vertexCount());
		assertEquals(18,graph.edgeCount());
	}
}
