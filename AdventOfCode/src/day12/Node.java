package day12;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Node {
	private String name;
	
	private List<Node> shortestPath = new LinkedList<>();
	private Integer distance = Integer.MAX_VALUE;
	Map<Node, Integer> adjacentNodes = new HashMap<>();
	
	public void addDestination(Node destination, int distance) {
		adjacentNodes.put(destination, distance);
	}
	
	public Node(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Map<Node, Integer> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!(obj instanceof Node)) return false;
		Node other = (Node)obj;
		
		if (other.name == this.name) return true;
		else return false;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
