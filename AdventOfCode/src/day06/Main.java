package day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		File file = new File("C:\\\\Users\\\\Korisnik\\\\git\\\\AdventOfCode\\\\AdventOfCode\\\\src\\\\day06\\\\input.txt");
		
		try (Scanner scanner = new Scanner(file)) {
			String line = scanner.nextLine();
			int n = 14;
			int start = 0;
			int mark = -1;
			while (n < line.length()) {
				String substring = line.substring(start, n);
				if (checkString(substring) == 14) { // TASK ONE: replace 14 with 4
					mark = n;
					System.out.println("First mark is at index " + mark);
					return;
				}
				n++;
				start++;
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static int checkString(String string) {
		
		for (int i =0; i< 14; i++) { // TASK ONE: replace 14 with 4
			for (int j = i+1; j< 14; j++) { // TASK ONE: replace 14 with 4
				if (string.charAt(i) == string.charAt(j)) {
					return -1;
				}
			}
		}
		
		return string.length();
	}
}




