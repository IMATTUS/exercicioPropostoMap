package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		File file = new File("in.csv");
		Scanner sc = null;
		Map<String, Integer> candidates = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			while (line != null) {
				String[] columns = line.split(",");
				int votes = 0;
				if (candidates.get(columns[0]) != null) {
					votes = candidates.get(columns[0]);
				}

				candidates.put(columns[0],Integer.valueOf(columns[1])+votes	);
				line = br.readLine();

			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		for (String key : candidates.keySet()) {
			System.out.println(key + ": " +candidates.get(key));
		}
		System.out.println();

	}

}
