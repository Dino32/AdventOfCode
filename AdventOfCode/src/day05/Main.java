package day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		File file = new File("C:\\\\Users\\\\Korisnik\\\\git\\\\AdventOfCode\\\\AdventOfCode\\\\src\\\\day05\\\\input.txt");
		List<Stack<Character>> stacks = new ArrayList<Stack<Character>>();
		for (int i = 0; i< 9; i++) {
			stacks.add(new Stack<Character>());
		}
		
		try (Scanner scanner = new Scanner(file)) {
			String line = null;
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				if (!line.equals("")) {
					for (int i = 1; i<= 9; i++) {
						if (i == 1) {
							if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') {
								stacks.get(i-1).push(line.charAt(i));
							}
						}
						else {
							if (line.charAt(i + (i-1) * 3) >= 'A' && line.charAt(i + (i-1) * 3) <= 'Z') {
								stacks.get(i-1).push(line.charAt(i + (i-1) * 3));
							}
						}; 
					}
				}
				else {
					break;
				}
			}
			
			List<Stack<Character>> stacksOther = new ArrayList<Stack<Character>>();
			
			for (int i = 0; i< 9; i++) {
				Stack<Character> stack = stacks.get(i);
				Stack<Character> tmp = new Stack<>();
				while (!stack.isEmpty()) {
					tmp.push(stack.pop());
				}
				stacksOther.add(tmp);
			}
			
			
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				String[] lineSplit = line.split(" ");
				int amount = Integer.parseInt(lineSplit[1]);
				int from = Integer.parseInt(lineSplit[3]);
				int to = Integer.parseInt(lineSplit[5]);
				
				Stack<Character> tmp = new Stack<>();
				for (int i = 0; i< amount; i++) {
					/* SOLUTION TASK ONE */
					char value = stacksOther.get(from-1).pop();
					tmp.push(value);
					//stacksOther.get(to-1).push(value);
				}
				while (!tmp.isEmpty()) {
					stacksOther.get(to-1).push(tmp.pop());
				}
				
			}

			int maxLength = 0;
			for (int i = 0; i<9; i++) {
				if (stacksOther.get(i).size() > maxLength) {
					maxLength = stacksOther.get(i).size();
				}
			}
			
			for (int i = 0; i< maxLength; i++) {
				for (int j = 0; j< 9; j++) {
					if (stacksOther.get(j).size() >= maxLength-i) {
						System.out.print(stacksOther.get(j).pop() + " ");
					}
					else {
						System.out.print("  ");
					}
				}
				System.out.println();
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}






