package day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		File file = new File("C:\\\\Users\\\\Korisnik\\\\git\\\\AdventOfCode\\\\AdventOfCode\\\\src\\\\day10\\\\input.txt");
		
		try (Scanner scanner = new Scanner(file)) {
			List<String> input = new ArrayList<>();
			while (scanner.hasNextLine()) {
				input.add(scanner.nextLine());
			}
			
			int x = 1;
			int cycles = 0;
			int signalStrengthSum = 0;
			String image[][] = new String[6][40];
			for (int i = 0; i< image.length; i++) {
				for (int j = 0; j< image[0].length; j++) {
					//image[i][j] = ".";
				}
			}
			
			for (String line : input) {
				String[] lineSplit = line.split(" ");
				String command = lineSplit[0];
				int value = 0;
				if (lineSplit.length > 1) {
					value = Integer.parseInt(lineSplit[1]);
				}
				int index;
				switch (command) {
					case "addx": 
						index = cycles % 40;
						if (index == x || index == x - 1 || index == x +1) {
							image[cycles / 40][index] = "#";
						}
						else {
							image[cycles / 40][index] = ".";
						}
						cycles++;
						signalStrengthSum += checkSignalStrength(cycles, x);
						index = cycles % 40;
						if (index == x || index == x - 1 || index == x +1) {
							image[cycles / 40][index] = "#";
						}
						else {
							image[cycles / 40][index] = ".";
						}
						cycles++;
						signalStrengthSum += checkSignalStrength(cycles, x);
						x += value;
						break;
					case "noop":
						index = cycles % 40;
						if (index == x || index == x - 1 || index == x +1) {
							image[cycles / 40][index] = "#";
						}
						else {
							image[cycles / 40][index] = ".";
						}
						cycles++;
						signalStrengthSum += checkSignalStrength(cycles, x);
						break;
				}
			}
			
			//System.out.println("Register X: " + x);
			//System.out.println("Cycles count: " + cycles);
			System.out.println("Signal Strength Sum: " + signalStrengthSum);
			
			for (int i = 0; i< image.length; i++) {
				for (int j = 0; j< image[0].length; j++) {
					System.out.print(image[i][j] + " ");
				}
				System.out.println();
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static int checkSignalStrength(int cycles, int x) {
		if (cycles == 20 || cycles == 60 || cycles == 100 || cycles == 140 || 
			cycles == 180 || cycles == 220) {
			//System.out.println(x);
			return cycles * x;
		}
		return 0;
	}
}






