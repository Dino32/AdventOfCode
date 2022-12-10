package day09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Task1 {
	public static void main(String[] args) {
		File file = new File("C:\\\\Users\\\\Korisnik\\\\git\\\\AdventOfCode\\\\AdventOfCode\\\\src\\\\day09\\\\input.txt");
		
		try (Scanner scanner = new Scanner(file)) {
			List<String> input = new ArrayList<>();
			while (scanner.hasNextLine()) {
				input.add(scanner.nextLine());
			}
			
			Set<Point> visited = new HashSet<>();
			Point head = new Point(0, 0);
			Point tail = new Point(0, 0);
			visited.add(tail);
			
			for (String line : input) {
				String parts[] = line.split(" ");
				String direction = parts[0];
				int steps = Integer.parseInt(parts[1]);
				switch(direction) {
					case "U" -> {
						
						for (int i = 0; i< steps; i++) {
							head = new Point(head.row - 1, head.column);
							if (Math.abs(head.row - tail.row) > 1) {
								tail = new Point(tail.row - 1, head.column);
								visited.add(tail);
							}
						}
						break;
					}
					case "D" -> {
						for (int i = 0; i< steps; i++) {
							head = new Point(head.row + 1, head.column);
							if (Math.abs(head.row - tail.row) > 1) {
								tail = new Point(tail.row + 1, head.column);
								visited.add(tail);
							}
						}
						break;
					}
					case "L" -> {
						for (int i = 0; i< steps; i++) {
							head = new Point(head.row, head.column - 1);
							if (Math.abs(head.column - tail.column) > 1) {
								tail = new Point(head.row, tail.column -1);
								visited.add(tail);
							}
						}
						break;
					}
					case "R" -> {
						for (int i = 0; i< steps; i++) {
							head = new Point(head.row, head.column + 1);
							if (Math.abs(head.column - tail.column) > 1) {
								tail = new Point(head.row, tail.column +1);
								visited.add(tail);
							}
						}
						break;
					}
				}
			}
			
			System.out.println("Visited grids: " + visited.size());
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

