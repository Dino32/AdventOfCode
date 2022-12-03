package day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		File file = new File("C:\\Users\\Korisnik\\git\\AdventOfCode\\AdventOfCode\\src\\day03\\input.txt");
		try (Scanner scanner = new Scanner(file)) {
			String line1 = null;
			String line2 = null;
			String line3 = null;
			int total = 0;
			while (scanner.hasNextLine()) {
				line1 = scanner.nextLine();
				line2 = scanner.nextLine();
				line3 = scanner.nextLine();
				
				total += badgesSum(line1, line2, line3);
			}
			System.out.println(total);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static int checkComponents(String line) {
		int total = 0;
		int half = line.length() / 2;
		String firstHalf = line.substring(0, half);
		String secondHalf = line.substring(half);
		
		for (int i = 0; i< half; i++) {
			char c = firstHalf.charAt(i);
			if (secondHalf.contains(String.valueOf(c))) {
				if (c >= 'a' && c <= 'z') {
					total += (c-'a') + 1;
				}
				else if (c >= 'A' && c <='Z') {
					total += (c-'A') + 27;
				}
				break;
			}
		}
		
		return total;
	}
	
	public static int badgesSum(String line1, String line2, String line3) {
		int total = 0;
		List<Character> chars = new ArrayList<>();
		
		for (char c1 : line1.toCharArray()) {
			for (char c2 : line2.toCharArray()) {
				if (c1 == c2) {
					chars.add(c1);
				}
			}
		}
		char badge = ' ';
		for (char c : chars) {
			for (char c3 : line3.toCharArray()) {
				if (c == c3) {
					badge = c;
					break;
				}
			}
		}
		
		if (badge >= 'a' && badge <= 'z') {
			total += (badge-'a') + 1;
		}
		else if (badge >= 'A' && badge <='Z') {
			total += (badge-'A') + 27;
		}
		
		return total;
	}
}
