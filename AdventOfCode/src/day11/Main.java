package day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Main {
	private static long masterDivisor = 1;
	public static void main(String[] args) {
		File file = new File("C:\\Users\\Korisnik\\git\\AdventOfCode\\AdventOfCode\\src\\day11\\input.txt");
		
		try (Scanner scanner = new Scanner(file)) {
			List<Monkey> monkeys = new ArrayList<>();
			List<String> input = new ArrayList<>();
			while (scanner.hasNextLine()) {
				input.add(scanner.nextLine());
			}
			
			int lineCount = 0;
			for (int i = 1; i<= 8; i++) {
				int id = 0;
				List<Long> items = new ArrayList<>();
				int increase = 0;
				String increaseType = "";
				int test = 0;
				int nextTrue = 0;
				int nextFalse = 0;
				for (int j = 0; j< 6; j++) {
					String line = input.get(lineCount++);
					if (j == 0) {
						String[] lineSplit = line.split(" ");
						String num = lineSplit[1].substring(0, 1);
						id = Integer.parseInt(num);
						
					}
					else if (j == 1) {
						String[] lineSplit = line.split(":");
						String[] itemsString = lineSplit[1].split(",");
						for (String item : itemsString) {
							items.add(Long.parseLong(item.trim()));
						}
 					}
					else if (j == 2) {
						String[] lineSplit = line.split("=");
						String[] itemsString = lineSplit[1].split(" ");
						if (itemsString[2].trim().equals("*")) {
							increaseType = "*";
						}
						else {
							increaseType = "+";
						}
						if (itemsString[3].trim().equals("old")) {
							increaseType = "itself";
						}
						else {
							increase = Integer.parseInt(itemsString[3].trim());
						}
					}
					else if (j == 3) {
						String[] lineSplit = line.split(" ");
						test = Integer.parseInt(lineSplit[lineSplit.length - 1].trim());
						masterDivisor *= test;
					}
					else if (j == 4) {
						String[] lineSplit = line.split(" ");
						nextTrue = Integer.parseInt(lineSplit[lineSplit.length - 1].trim());
					}
					else if (j == 5) {
						String[] lineSplit = line.split(" ");
						nextFalse = Integer.parseInt(lineSplit[lineSplit.length - 1].trim());
					}
				}
				lineCount++;
				Monkey monkey = new Monkey(id, items, increase, increaseType, test, nextTrue, nextFalse);
				monkeys.add(monkey);
			}
			System.out.println(monkeys);
			
			int[] itemsInspected = new int[monkeys.size()];
			for (int i = 0; i< itemsInspected.length; i++) {
				itemsInspected[i] = 0;
			}
			for (int i = 0; i< 10000 ; i++) {
				int j = 0;
				for (Monkey monkey : monkeys) {
					for (long item : monkey.getItems()) {
						itemsInspected[j]++;
						long worryLevel = item;
						switch (monkey.getIncreaseType()) {
							case "*":
								worryLevel = ((worryLevel* monkey.getIncrease()));
								break;
							case "+":
								worryLevel = ((worryLevel + monkey.getIncrease()));
								break;
							case "itself":
								worryLevel = ((worryLevel * item));
								break;
						}
						worryLevel %= masterDivisor;
						
						if (worryLevel % monkey.getTest()== 0) {
							monkeys.get(monkey.getNextTrue()).getItems().add(worryLevel);
						}
						else {
							monkeys.get(monkey.getNextFalse()).getItems().add(worryLevel);
						}
					}
					monkey.setItems(new ArrayList<>());
					j++;
				}
			}
			
			for (Monkey monkey : monkeys) {
				System.out.println(monkey.getItems());
			}
			
			for (int i = 0; i< itemsInspected.length; i++) {
				System.out.println("Monkey " + i + " inspected items " + itemsInspected[i] + " times.");
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
