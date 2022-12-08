package day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
		
		File file = new File("C:\\\\Users\\\\Korisnik\\\\git\\\\AdventOfCode\\\\AdventOfCode\\\\src\\\\day08\\\\input.txt");
		try (Scanner scanner = new Scanner(file)) {
			List<String> input = new ArrayList<>();
			while (scanner.hasNextLine()) {
				input.add(scanner.nextLine());
			}
			
			int visibleTrees = 0;
			int rowCount = input.size();
			int columnCount = input.get(0).length();
			
			visibleTrees += input.size() * 2;
			visibleTrees += input.get(0).length() * 2 - 4;
			
			for (int i = 1; i < rowCount - 1; i++) {
				for (int j = 1; j< columnCount - 1; j++) {
					boolean foundHeigherTop = false;
					boolean foundHeigherBottom = false;
					boolean foundHeigherLeft = false;
					boolean foundHeigherRight = false;
					// check Up
					for (int k = i - 1; k >= 0; k--) {
						if (input.get(i).charAt(j) <= input.get(k).charAt(j)) {
							foundHeigherTop = true;
							break;
						}
					}
					
					
					// check Down
					for (int k = i +1; k < rowCount; k++) {
						if (input.get(i).charAt(j) <= input.get(k).charAt(j)) {
							foundHeigherBottom = true;
							break;
						}
					}
					
					
					// check Left
					for (int k = j-1; k >= 0; k--) {
						if (input.get(i).charAt(j) <= input.get(i).charAt(k)) {
							foundHeigherLeft = true;
							break;
						}
					}
					
					
					// check Right
					for (int k = j + 1; k < columnCount; k++) {
						if (input.get(i).charAt(j) <= input.get(i).charAt(k)) {
							foundHeigherRight = true;
							break;
						}
					}
					
					if (!foundHeigherTop || !foundHeigherBottom || !foundHeigherRight || !foundHeigherLeft) {
						visibleTrees++;
					}
				}
			}
			
			int topScenicScore = 0;
			
			for (int i = 0; i < rowCount; i++) {
				for (int j = 0; j< columnCount; j++) {
					int treesUp = 0;
					int treesDown = 0;
					int treesLeft = 0;
					int treesRight = 0;
					
					// check Up
					for (int k = i - 1; k >= 0; k--) {
						treesUp++;
						if (input.get(i).charAt(j) <= input.get(k).charAt(j)) {
							break;
						}
					}
					
					
					// check Down
					for (int k = i +1; k < rowCount; k++) {
						treesDown++;
						
						if (input.get(i).charAt(j) <= input.get(k).charAt(j)) {
							break;
						}
					}
					
					
					// check Left
					for (int k = j-1; k >= 0; k--) {
						if (input.get(i).charAt(j) >= input.get(i).charAt(k)) {
							treesLeft++;
						}
						else {
							break;
						}
						
						if (input.get(i).charAt(j) <= input.get(i).charAt(k)) {
							break;
						}
					}
					
					
					// check Right
					for (int k = j + 1; k < columnCount; k++) {
						treesRight++;
						
						if (input.get(i).charAt(j) <= input.get(i).charAt(k)) {
							break;
						}
					}
					
					int scenicScore = treesUp * treesDown * treesLeft * treesRight;
					if (topScenicScore == 0 || scenicScore > topScenicScore) {
						topScenicScore = scenicScore;
					}
				}
			}
			
			
			
			System.out.println("Visible Trees: " + visibleTrees);
			System.out.println("Top Scenic Score: " + topScenicScore);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
