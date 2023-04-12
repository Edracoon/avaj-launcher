package srcs;
import java.util.Random;

public class WeatherProvider {
	// Intance of WeatherProvider for singleton
	private static WeatherProvider instance;

	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	// Private constructor for singleton
	private WeatherProvider() { }

	public static WeatherProvider getProvider() {
		if (instance == null) {
			instance = new WeatherProvider();
		}
		return instance;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		// Add some randomness to the weather (Weather is not always an exact science ;D)
		// int random = new Random().nextInt(4);
		int xyz = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight(); // + random;
		return weather[xyz % 4];
	}
}
