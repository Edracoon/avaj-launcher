package srcs;

// ◦ SUN - Latitude increases with 10, Height increases with 2
// ◦ RAIN - Latitude increases with 5
// ◦ FOG - Latitude increases with 1
// ◦ SNOW - Height decreases with 7

public class JetPlane extends Aircraft implements Flyable {
	protected WeatherTower weatherTower;

	public JetPlane(String p_name, Coordinates p_coordinate) {
		super(p_name, p_coordinate);
	}

	@Override
	public void updateConditions() {
		String currWeather = this.weatherTower.getWeather(coordinates);
		System.out.println("JetPlane #" + this.name + " (" + this.id + ") has " + currWeather);
		if (currWeather.equals("SUN"))
			this.coordinates.updateCoordinates(0, 10, 2);
		else if (currWeather.equals("RAIN"))
			this.coordinates.updateCoordinates(0, 5, 0);
		else if (currWeather.equals("FOG"))
			this.coordinates.updateCoordinates(0, 1, 0);
		else if (currWeather.equals("SNOW"))
			this.coordinates.updateCoordinates(0, 0, -7);
		// Unregister if height is 0
		if (this.coordinates.getHeight() <= 0) {
			this.weatherTower.unregister(this);
			System.out.println("\u001B[1m" + "Tower says: \"JetPlane #" + this.name + " (" + this.id + "): landing and unregistered from weather tower.\"" + "\u001B[0m");
		}
	}

	@Override
	public void registerTower(WeatherTower p_weatherTower) {
		this.weatherTower = p_weatherTower;
	}
}