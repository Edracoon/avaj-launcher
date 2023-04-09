package srcs;

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
		int xyz = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
		return weather[xyz % 4];
	}
}
