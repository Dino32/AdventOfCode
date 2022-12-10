package day09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Task2 {
	public static void main(String[] args) {
		File file = new File("C:\\\\Users\\\\Korisnik\\\\git\\\\AdventOfCode\\\\AdventOfCode\\\\src\\\\day09\\\\input.txt");
		
		try (Scanner scanner = new Scanner(file)) {
			List<String> input = new ArrayList<>();
			while (scanner.hasNextLine()) {
				input.add(scanner.nextLine());
			}
			
			Set<Point> s1Visited = new HashSet<>();
			Set<Point> s2Visited = new HashSet<>();
			List<Point> snake1 = new ArrayList<>();
			List<Point> snake2 = new ArrayList<>();
			for(int i = 0; i < 2; i++)
				snake1.add(new Point(0, 0));
			for(int i = 0; i < 10; i++)
				snake2.add(new Point(0, 0));
			s1Visited.add(snake1.get(snake1.size() - 1));
			s2Visited.add(snake2.get(snake2.size() - 1));

			for(String s : input)
			{
				String[] parts = s.split(" ");
				Direction dir = switch(parts[0])
						{
							case "U" -> Direction.UP;
							case "D" -> Direction.DOWN;
							case "L" -> Direction.LEFT;
							default -> Direction.RIGHT;
						};
				for(int i = 0; i < Integer.parseInt(parts[1]); i++)
				{
					moveSnake(dir, snake1, s1Visited);
					moveSnake(dir, snake2, s2Visited);
				}
			}
			
			System.out.println("Visited grids: " + s1Visited.size());
			System.out.println("Visited grids: " + s2Visited.size());
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void moveSnake(Direction dir, List<Point> snake, Set<Point> visited)
	{
		Point head = snake.get(0);
		head = dir.movePointInDir(head);
		snake.set(0, head);
		for(int j = 1; j < snake.size(); j++)
		{
			head = snake.get(j - 1);
			Point tail = snake.get(j);
			int rowDif = Math.abs(head.row - tail.row);
			int colDir = Math.abs(head.column - tail.column);
			if(rowDif > colDir)
			{
				if(head.row - tail.row > 1)
					tail = new Point(tail.row + 1, head.column);
				if(tail.row - head.row > 1)
					tail = new Point(tail.row - 1, head.column);
			}
			else if(rowDif < colDir)
			{
				if(head.column - tail.column > 1)
					tail = new Point(head.row, tail.column + 1);
				if(tail.column - head.column > 1)
					tail = new Point(head.row, tail.column - 1);
			}
			else if(rowDif > 1)
			{
				if(head.row - tail.row > 1)
					tail = new Point(tail.row + 1, tail.column);
				if(tail.row - head.row > 1)
					tail = new Point(tail.row - 1, tail.column);
				if(head.column - tail.column > 1)
					tail = new Point(tail.row, tail.column + 1);
				if(tail.column - head.column > 1)
					tail = new Point(tail.row, tail.column - 1);
			}

			snake.set(j, tail);
			if(j == snake.size() - 1)
				visited.add(tail);
		}
	}

	private enum Direction
	{
		UP,
		DOWN,
		LEFT,
		RIGHT;

		public Point movePointInDir(Point p)
		{
			return switch(this)
					{
						case UP -> new Point(p.row - 1, p.column);
						case DOWN -> new Point(p.row + 1, p.column);
						case LEFT -> new Point(p.row, p.column - 1);
						case RIGHT -> new Point(p.row, p.column + 1);
					};
		}
	}
}	








