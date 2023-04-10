package srcs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Data {

	public int				simulations;

	public void parseFile(String filename, WeatherTower weatherTower) {

		File    file = new File(filename);

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			int i = -1;
			System.out.println("Reading file: " + filename);
			while ((line = reader.readLine()) != null) {
				i++;
				if (i == 0) {
					try { simulations = Integer.parseInt(line, 10); }
					catch (NumberFormatException e) {
						throw new CustomException("Error\nInvalid number format at line " + (i + 1) + " (Expected a number of simulations)");
					}
					if (simulations < 0)
						throw new CustomException("Error\nInvalid number of simulations at line " + (i + 1) + " (Expected a positive number)");
				}
				else {
					String[]	split = line.split(" ");
					if (split.length != 5)
						throw new CustomException("Error\nInvalid number of arguments at line " + (i + 1));
					if (!split[0].equals("Helicopter")
						&& !split[0].equals("JetPlane")
						&& !split[0].equals("Baloon"))
						throw new CustomException("Error\nInvalid aircraft type: \'" + split[0] + "\' at line " + (i + 1));
					// Create coordinates and aircraft
					try {
						int longi = Integer.parseInt(split[2], 10);
						int lati = Integer.parseInt(split[3], 10);
						int height = Integer.parseInt(split[4], 10);
						if (longi < 0 || lati < 0 || height < 0)
							throw new CustomException("Error\nInvalid coordinates at line " + (i + 1) + " (Expected positive numbers)");
						if (height > 100) height = 100;
						Flyable aircraft = AircraftFactory.getInstance().newAircraft(split[0], split[1], longi, lati, height);
						weatherTower.register(aircraft);
						aircraft.registerTower(weatherTower);
					}
					catch (NumberFormatException e) {
						throw new CustomException("Error at line " + (i + 1) + ": Invalid number format");
					}
				}
			}
			System.out.println("Simulations: " + simulations);
		}
		catch (IOException e) {
			System.out.println("Error reading file: " + filename + " " + e.getMessage());
		}
		catch (CustomException e) {
			System.out.println(e.getMessage());
		}
	}
}
