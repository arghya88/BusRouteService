package com.eurogo.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.eurogo.exception.VertexNotFoundException;

public class Graph<T> {
	private final Map<T, Node<T>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    /**
     * Adds a vertex to the graph.
     * @param vertex        vertex to add
     */
    public boolean addVertex(T vertex) {
        if (containsVertex(vertex)) {
            return false;
        }
        adjacencyList.put(vertex, new Node<>(vertex));
        return true;
    }

    /**
     * Adds a directed edge between two vertices in the graph.
     * @param vertex1       vertex where the (directed) edge begins
     * @param vertex2       vertex where the (directed) edge ends
     * @throws VertexNotFoundException 
     */
    public boolean addEdge(T vertex1, T vertex2) throws VertexNotFoundException {
        return addEdge(vertex1, vertex2, 0);
    }

    /**
     * Adds a weighted directed edge between two vertices in the graph.
     * @param vertex1       vertex where the (directed) edge begins
     * @param vertex2       vertex where the (directed) edge ends
     * @param weight        weight of the edge
     * @throws VertexNotFoundException 
     */
    public boolean addEdge(T vertex1, T vertex2, int weight) throws VertexNotFoundException {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            throw new VertexNotFoundException("Vertex does not exist");
        }

        Node<T> node1 = getNode(vertex1);
        Node<T> node2 = getNode(vertex2);
        return node1.addEdge(node2, weight);
    }

    /**
     * Remove a vertex from the graph.
     * @param vertex        vertex to be removed
     * @return      true if the vertex was removed, false if no such vertex was found.
     */
    public boolean removeVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            return false;
        }

        final Node<T> toRemove = getNode(vertex);

        adjacencyList.values().forEach(node -> node.removeEdge(toRemove));

        adjacencyList.remove(vertex);
        return true;
    }

    /**
     * Method to remove a directed edge between two vertices in the graph.
     * @param vertex1       vertex where the (directed) edge begins
     * @param vertex2       vertex where the (directed) edge ends
     * @return  true if the edge was removed, false if no such edge was found.
     */
    public boolean removeEdge(T vertex1, T vertex2) {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            return false;
        }
        return getNode(vertex1).removeEdge(getNode(vertex2));
    }

    /**
     * Method to get the number of vertices in the graph.
     * @return      count of vertices
     */
    public int vertexCount() {
        return adjacencyList.keySet().size();
    }

    /**
     * Method to get the number of edges in the graph.
     * @return      count of edges
     */
    public int edgeCount() {
        return adjacencyList.values()
                .stream()
                .mapToInt(Node::getEdgeCount)
                .sum();
    }

    /**
     * Method to check if a vertex exists in the graph.
     * @param vertex    vertex which is to be checked
     * @return  returns true if the graph contains the vertex, false otherwise
     */
    public boolean containsVertex(T vertex) {
        return adjacencyList.containsKey(vertex);
    }

    /**
     * Method to check if an edge exists in the graph.
     * @param vertex1       vertex where the (directed) edge begins
     * @param vertex2       vertex where the (directed) edge ends
     * @return   returns true if the graph contains the edge, false otherwise
     */
    public boolean containsEdge(T vertex1, T vertex2) {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            return false;
        }
        return getNode(vertex1).hasEdge(getNode(vertex2));
    }

    /**
     * Method to get the shortest path from startVertex to endVertex.
     * @param startVertex   vertex where the path begins
     * @param endVertex     vertex where the path ends
     * @return  list of vertices in the shortest path from startVertex to endVertex,
     *          null if no such path exists.
     */
    public List<T> shortestPath(T startVertex, T endVertex) {
        if (!containsVertex(startVertex) || !containsVertex(endVertex)) {
            return null;
        }
        breadthFirstSearch(startVertex);

        List<T> path = new ArrayList<>();
        Node<T> end = getNode(endVertex);
        while (end != null && end != getNode(startVertex)) {
            path.add(end.vertex());
            end = end.parent();
        }
        if (end == null) {
            return null;
        }
        else {
            Collections.reverse(path);
        }
        return path;
    }

    private void breadthFirstSearch(T startVertex) {
        if (!containsVertex(startVertex)) {
            throw new RuntimeException("Vertex does not exist");
        }

        resetGraph();

        Queue<Node<T>> queue = new LinkedList<>();
        Node<T> start = getNode(startVertex);
        queue.add(start);

        while (!queue.isEmpty()) {
            Node<T> first = queue.remove();
            first.setVisited(true);
            first.edges().forEach(edge -> {
                Node<T> neighbour = edge.toNode();
                if (!neighbour.isVisited()) {
                    neighbour.setParent(first);
                    queue.add(neighbour);
                }
            });
        }
    }

    private Node<T> getNode(T value) {
        return adjacencyList.get(value);
    }

    private void resetGraph() {
        adjacencyList.keySet().forEach(key -> {
            Node<T> node = getNode(key);
            node.setParent(null);
            node.setVisited(false);
        });
    }
}
