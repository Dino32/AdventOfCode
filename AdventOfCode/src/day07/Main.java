package day07;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		java.io.File inputFile = new java.io.File("C:\\\\Users\\\\Korisnik\\\\git\\\\AdventOfCode\\\\AdventOfCode\\\\src\\\\day07\\\\input.txt");
		try (Scanner scanner = new Scanner(inputFile)){
			String line;
			Folder root = new Folder();
			root.name = "/";
			Folder currentFolder = root;
			List<String> input = new ArrayList<>();
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				input.add(line);
			}
			
			for (int i = 1; i< input.size(); i++) {
				String[] parts = input.get(i).split(" ");
				
				if (parts[0].equals("$")) {
					if (parts[1].equals("cd")) {
						if (parts[2].equals("..")) {
							currentFolder = currentFolder.parent;
						}
						else {
							for (Node n: currentFolder.contents) {
								if (n.name.equals(parts[2])) {
									currentFolder = (Folder) n;
									break;
								}
							}
						}
					}
				}
				else if (parts[0].equals("dir")) {
					Folder folder = new Folder();
					folder.name = parts[1];
					folder.parent = currentFolder;
					currentFolder.contents.add(folder); 
				}
				else {
					File file = new File();
					file.parent = currentFolder;
					file.name = parts[1];
					file.size = Integer.parseInt(parts[0]);
					currentFolder.contents.add(file);
				}
			}
			
			List<Folder> smallerFolder =  new ArrayList<>();
			List<Folder> toCheck =  new ArrayList<>();
			toCheck.addAll(root.getSubFolders());
			
			while (toCheck.size() > 0) {
				Folder fold = toCheck.remove(0);
				toCheck.addAll(fold.getSubFolders());
				if (fold.getSize() <= 100000) {
					smallerFolder.add(fold);
				}
			}
			
			long sum = 0;
			for (Folder f : smallerFolder) {
				sum += f.getSize();
			}
			
			System.out.println("Size: " + sum);
			
			long totalSpace = 70000000;
			long freeSpace = totalSpace - root.getSize();
			System.out.println("Free Space: " + freeSpace);
			long neededSpace = 30000000;
			
			long min = Integer.MAX_VALUE;
			toCheck =  new ArrayList<>(root.getSubFolders());
			
			while (toCheck.size() > 0) {
				Folder fold = toCheck.remove(0);
				toCheck.addAll(fold.getSubFolders());
				long size = fold.getSize();
				if (size + freeSpace > neededSpace && size < min) {
					min = size;
				}
			}
			
			System.out.println("Folder to delete: " + min);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static abstract class Node {
		public String name;
		public Folder parent;
		
		public abstract long getSize();
		
	}
	
	public static class File extends Node {
		public int size;

		@Override
		public long getSize() {
			return size;
		}
	}
	
	public static class Folder extends Node {
		public List<Node> contents = new ArrayList<>();
		
		@Override
		public long getSize() {
			long size = 0; 
			for (Node n : contents) {
				size += n.getSize();
			}
			return size;
		}
		
		public List<Folder> getSubFolders() {
			List<Folder> folders = new ArrayList<>();
			for (Node n : contents) {
				if (n instanceof Folder) {
					folders.add((Folder) n);
				}
			}
			
			return folders;
		}
	}
}






