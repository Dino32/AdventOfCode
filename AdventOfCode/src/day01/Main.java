package day01;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Korisnik\\eclipse-workspace\\AdventOfCode\\src\\day1\\input.txt");
		Scanner scanner = new Scanner(file);
		List<Integer> totalCalories = new ArrayList<>();
		
		String line = null;
		while (scanner.hasNextLine()) 
		{
			int total = 0;
			while (true) {
				if (scanner.hasNextLine()) {
					line = scanner.nextLine();
				}
				else 
				{
					break;
				}
				if (line.equals("")) {
					break;
				}
				total += Integer.parseInt(line);
			}
			totalCalories.add(total);
		}
		scanner.close();
		
		totalCalories = totalCalories.stream().sorted((e1, e2) -> e1.compareTo(e2)).collect(Collectors.toList());
		
		System.out.println(totalCalories.get(totalCalories.size() - 2) + totalCalories.get(totalCalories.size() - 3) + totalCalories.get(totalCalories.size() - 1));
	}
}
