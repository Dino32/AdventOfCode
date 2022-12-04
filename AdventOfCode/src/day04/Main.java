package day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		File file = new File("C:\\\\Users\\\\Korisnik\\\\git\\\\AdventOfCode\\\\AdventOfCode\\\\src\\\\day04\\\\input.txt");
		
		try (Scanner scanner = new Scanner(file)) {
			String line = null;
			int total = 0;
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				if (solve2(line)) {
					total++;
				}
			}
			
			System.out.println(total);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	 static class Pair<T> {
		private T firstElem;
		private T secondElem;
		
		public Pair(T firstElem, T secondElem) {
			this.firstElem = firstElem;
			this.secondElem = secondElem;
		}

		public T getFirstElem() {
			return firstElem;
		}

		public void setFirstElem(T firstElem) {
			this.firstElem = firstElem;
		}

		public T getSecondElem() {
			return secondElem;
		}
		
		public void setSecondElem(T secondElem) {
			this.secondElem = secondElem;
		}
	
		@Override
		public String toString() {
			return "(" + firstElem + ", " + secondElem + ")";
		}
	}
	
	public static boolean solve1(String line) {
		String split[] = line.split(",");
		
		String firstString[] = split[0].split("-");
		String secondString[] = split[1].split("-");
		
		Pair<Integer> firstPair = new Pair<Integer>(Integer.parseInt(firstString[0]), Integer.parseInt(firstString[1]));
		Pair<Integer> secondPair = new Pair<Integer>(Integer.parseInt(secondString[0]), Integer.parseInt(secondString[1]));
		
		if (firstPair.getFirstElem() >= secondPair.getFirstElem()) {
			if (firstPair.getSecondElem() <= secondPair.getSecondElem()) {
				return true;
			}
		}
		
		if (secondPair.getFirstElem() >= firstPair.getFirstElem()) {
			if (secondPair.getSecondElem() <= firstPair.getSecondElem()) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean solve2(String line) {
		String split[] = line.split(",");
		
		String firstString[] = split[0].split("-");
		String secondString[] = split[1].split("-");
		
		Pair<Integer> firstPair = new Pair<Integer>(Integer.parseInt(firstString[0]), Integer.parseInt(firstString[1]));
		Pair<Integer> secondPair = new Pair<Integer>(Integer.parseInt(secondString[0]), Integer.parseInt(secondString[1]));
		
		if (firstPair.getFirstElem() >= secondPair.getFirstElem()) {
			if (firstPair.getFirstElem() <= secondPair.getSecondElem()) {
				return true;
			}
		}
		
		if (secondPair.getFirstElem() >= firstPair.getFirstElem()) {
			if (secondPair.getFirstElem() <= firstPair.getSecondElem()) {
				return true;
			}
		}
		
		return false;
	}
}











