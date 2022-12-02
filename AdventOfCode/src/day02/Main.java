package day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		File file = new File("C:\\Users\\Korisnik\\eclipse-workspace\\AdventOfCode\\src\\day2\\input.txt");
		try(Scanner scanner = new Scanner(file)) {
			int total = 0;
			String line = null;
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				String lineSplit[] = line.split(" ");
				total += strategy(lineSplit[0], lineSplit[1]);
			}
			System.out.println(total);
		}
		catch(FileNotFoundException exception) {
			exception.printStackTrace();
		}
	}
	
	public static int strategy(String opponent, String yourPlay) {
		int total = 0;
		switch (opponent) {
		case "A":
			if (yourPlay.equals("X")) {
				total += 3;
			} 
			else if (yourPlay.equals("Y")) {
				total += 1;
				total += 3;
			}
			else if (yourPlay.equals("Z")) {
				total += 2;
				total += 6;
			}
			break;
		case "B":
			if (yourPlay.equals("X")) {
				total += 1;
			} 
			else if (yourPlay.equals("Y")) {
				total += 2;
				total += 3;
			}
			else if (yourPlay.equals("Z")) {
				total += 3;
				total += 6;
			}
			break;
		case "C":
			if (yourPlay.equals("X")) {
				total += 2;
			} 
			else if (yourPlay.equals("Y")) {
				total += 3;
				total += 3;
			}
			else if (yourPlay.equals("Z")) {
				total += 1;
				total += 6;
			}
			break;
		}
		
		return total;
	}
	
	public static int checkOutcome(String opponent, String yourPlay) {
		int total = 0;
		switch (opponent) {
		case "A":
			if (yourPlay.equals("X")) {
				total += 1;
				total += 3;
			} 
			else if (yourPlay.equals("Y")) {
				total += 2;
				total += 6;
			}
			else if (yourPlay.equals("Z")) {
				total += 3;
			}
			break;
		case "B":
			if (yourPlay.equals("X")) {
				total += 1;
			} 
			else if (yourPlay.equals("Y")) {
				total += 2;
				total += 3;
			}
			else if (yourPlay.equals("Z")) {
				total += 3;
				total += 6;
			}
			break;
		case "C":
			if (yourPlay.equals("X")) {
				total += 1;
				total += 6;
			} 
			else if (yourPlay.equals("Y")) {
				total += 2;
			}
			else if (yourPlay.equals("Z")) {
				total += 3;
				total += 3;
			}
			break;
		}
		
		return total;
	}
}