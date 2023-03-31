package srcs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Data {

	public int simulations;

	public void parseFile(String filename) {

		File    file = new File(filename);

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			int i = -1;
			System.out.println("Reading file: " + filename);
			while ((line = reader.readLine()) != null) {
				i++;
				System.out.println("L" + i + ": " + line);
				if (i == 0)
					simulations = Integer.parseInt(line, 10);
				else {
					String[]    split = line.split(" ");
					// Coordinates  coordinates = new Coordinates(Integer.parseInt(split[0], 10), Integer.parseInt(split[1], 10), Integer.parseInt(split[2], 10));
					// System.out.println("Coordinates: " + line);
				}

			}
			System.out.println("Simulations: " + simulations);

		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}

	}
}
