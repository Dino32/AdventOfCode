package day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		File file = new File("C:\\Users\\Korisnik\\git\\AdventOfCode\\AdventOfCode\\src\\day12\\input.txt");
		
		try (Scanner scanner = new Scanner(file)) {
			List<String> input = new ArrayList<>();
			
			while (scanner.hasNextLine()) {
				input.add(scanner.nextLine());
			}
			
			int startX = -1;
			int startY = -1;
			int targetX = -1;
			int targetY = -1;
			char[][] grid = new char[input.size()][input.get(0).length()];
			
			for (int i = 0; i< input.size(); i++) {
				for (int j = 0; j< input.get(0).length(); j++) {
					if (input.get(i).charAt(j) == 'S') {
						startX = j;
						startY = i;
					}
					if (input.get(i).charAt(j) == 'E') {
						targetX = j;
						targetY = i;
					}
					grid[i][j] = input.get(i).charAt(j);
				}
			}
			
			for (int i = 0; i< input.size(); i++) {
				for (int j = 0; j< input.get(0).length(); j++) {
					System.out.print(input.get(i).charAt(j));
				}
				System.out.println();
			}
			
			List<List<Node>> nodes = new ArrayList<>();
			Node nodeStart = null;
			Node nodeTarget = null;
			
			for (int i = 0; i< input.size(); i++) {
				List<Node> rowNodes = new ArrayList<>();
				for (int j = 0; j< input.get(0).length(); j++) {
					Node node;
					if (input.get(i).charAt(j) == 'S') {
						node = new Node("S");
						nodeStart = node;
					}
					else if (input.get(i).charAt(j) == 'E') {
						node = new Node("E");
						nodeTarget = node;
					}
					else {
						node = new Node("" + input.get(i).charAt(j));
					}
					
					rowNodes.add(node);
				}
				nodes.add(rowNodes);
			}
			
			for (int i = 0; i< nodes.size(); i++) {
				for (int j = 0; j< nodes.get(0).size(); j++) {
					Node node = nodes.get(i).get(j);
					// right
					if (j < nodes.get(0).size() -1) {
							if (input.get(i).charAt(j+1) == 'E') {
								if (input.get(i).charAt(j) == 'z' ||
									input.get(i).charAt(j) == 'z' + 1 ||
									input.get(i).charAt(j) == 'z') {
									node.addDestination(nodes.get(i).get(j+1), 1);
								}
							}
							else if (input.get(i).charAt(j+1) <= input.get(i).charAt(j) - 1 ||
									 input.get(i).charAt(j+1) == input.get(i).charAt(j) + 1 ||
									 input.get(i).charAt(j+1) == input.get(i).charAt(j)) {
								node.addDestination(nodes.get(i).get(j+1), 1);
							}
							else if (input.get(i).charAt(j) == 'S') {
								if (input.get(i).charAt(j+1) == 'a' - 1 ||
									input.get(i).charAt(j+1) == 'a' + 1 ||
									input.get(i).charAt(j+1) == 'a') {
									node.addDestination(nodes.get(i).get(j+1), 1);
								}
							}
							else if (input.get(i).charAt(j) == 'E') {
								if (input.get(i).charAt(j+1) <= 'z' - 1 ||
									input.get(i).charAt(j+1) == 'z' + 1 ||
									input.get(i).charAt(j+1) == 'z') {
									node.addDestination(nodes.get(i).get(j+1), 1);
								}
							}
					}
					// left
					if (j > 0) {
							if (input.get(i).charAt(j-1) == 'E') {
								if (input.get(i).charAt(j) == 'z' - 1 ||
									input.get(i).charAt(j) == 'z' + 1 ||
									input.get(i).charAt(j) == 'z') {
									node.addDestination(nodes.get(i).get(j-1), 1);
								}
							}
							else if (input.get(i).charAt(j-1) <= input.get(i).charAt(j) - 1 ||
									 input.get(i).charAt(j-1) == input.get(i).charAt(j) + 1 ||
									 input.get(i).charAt(j-1) == input.get(i).charAt(j)) {
								node.addDestination(nodes.get(i).get(j-1), 1);
							}
							else if (input.get(i).charAt(j) == 'S') {
								if (input.get(i).charAt(j-1) == 'a' - 1 ||
									input.get(i).charAt(j-1) == 'a' + 1 ||
									input.get(i).charAt(j-1) == 'a') {
									node.addDestination(nodes.get(i).get(j-1), 1);
								}
							}
							else if (input.get(i).charAt(j) == 'E') {
								if (input.get(i).charAt(j-1) <= 'z' - 1 ||
									input.get(i).charAt(j-1) == 'z' + 1 ||
									input.get(i).charAt(j-1) == 'z') {
									node.addDestination(nodes.get(i).get(j-1), 1);
								}
							}
					}
					// up
					if (i > 0) {
						if (input.get(i - 1).charAt(j) <= input.get(i).charAt(j) - 1 ||
							input.get(i - 1).charAt(j) == input.get(i).charAt(j) + 1 ||
							input.get(i - 1).charAt(j) == input.get(i).charAt(j))
							node.addDestination(nodes.get(i-1).get(j), 1);
						else if (input.get(i-1).charAt(j) == 'E') {
							if (input.get(i).charAt(j) == 'z' - 1 ||
								input.get(i).charAt(j) == 'z' + 1 ||
								input.get(i).charAt(j) == 'z') {
								node.addDestination(nodes.get(i-1).get(j), 1);
							}
						}
						else if (input.get(i).charAt(j) == 'S') {
							if (input.get(i-1).charAt(j) == 'a' - 1 ||
								input.get(i-1).charAt(j) == 'a' + 1 ||
								input.get(i-1).charAt(j) == 'a') {
								node.addDestination(nodes.get(i-1).get(j), 1);
							}
						}
						else if (input.get(i).charAt(j) == 'E') {
							if (input.get(i-1).charAt(j) <= 'z' - 1 ||
								input.get(i-1).charAt(j) == 'z' + 1 ||
								input.get(i-1).charAt(j) == 'z') {
								node.addDestination(nodes.get(i-1).get(j), 1);
							}
						}
						
					}
					// down
					if (i != nodes.size() - 1) {
						if (input.get(i + 1).charAt(j) <= input.get(i).charAt(j) - 1 ||
							input.get(i + 1).charAt(j) == input.get(i).charAt(j) + 1 ||
							input.get(i + 1).charAt(j) == input.get(i).charAt(j))
							node.addDestination(nodes.get(i+1).get(j), 1);
						else if (input.get(i+1).charAt(j) == 'E') {
							if (input.get(i).charAt(j) == 'z'-1 ||
								input.get(i).charAt(j) == 'z' + 1 ||
								input.get(i).charAt(j) == 'z') {
								node.addDestination(nodes.get(i+1).get(j), 1);
							}
						}
						else if (input.get(i).charAt(j) == 'S') {
							if (input.get(i+1).charAt(j) == 'a' - 1 ||
								input.get(i+1).charAt(j) == 'a' + 1 ||
								input.get(i+1).charAt(j) == 'a') {
								node.addDestination(nodes.get(i+1).get(j), 1);
							}
						}
						else if (input.get(i).charAt(j) == 'E') {
							if (input.get(i+1).charAt(j) <= 'z' - 1 ||
								input.get(i+1).charAt(j) == 'z' + 1 ||
								input.get(i+1).charAt(j) == 'z') {
								node.addDestination(nodes.get(i+1).get(j), 1);
							}
						}
					}
				}
			}
			
			Graph graph = new Graph();
			for (int i = 0; i< nodes.size(); i++) {
				for (int j = 0; j< nodes.get(0).size(); j++) {
					graph.addNode(nodes.get(i).get(j));
				}
			}
			graph = Dijkstra.calculateShortestPathFromSource(graph, nodeStart);
			System.out.println("Task 1: " + nodeTarget.getDistance());
			
			
			int minDistance = Integer.MAX_VALUE;
			
			for (int i = 0; i< nodes.size(); i++) {
				for (int j = 0; j< nodes.get(0).size(); j++) {
					Node node = nodes.get(i).get(j);
					if (node.getName().equals("a") || node.getName().equals("S")) {
						nodeStart = node;
						graph = Dijkstra.calculateShortestPathFromSource(graph, nodeStart);
						if (nodeTarget.getDistance() < minDistance) {
							minDistance = nodeTarget.getDistance();
						}
					}
				}
			}	
				
			
			System.out.println("Task 2: " + minDistance);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}



