package srcs;

// ◦ SUN - Longitude increases with 10, Height increases with 2
// ◦ RAIN - Longitude increases with 5
// ◦ FOG - Longitude increases with 1
// ◦ SNOW - Height decreases with 12

public class Helicopter extends Aircraft implements Flyable {
	protected WeatherTower weatherTower;

	public Helicopter(String p_name, Coordinates p_coordinate) {
		super(p_name, p_coordinate);
	}

	@Override
	public void updateConditions() {
		String currWeather = this.weatherTower.getWeather(coordinates);
		System.out.println("Helicopter #" + this.name + " (" + this.id + ") has " + currWeather);
		if (currWeather.equals("SUN"))
			this.coordinates.updateCoordinates(10, 0, 2);
		else if (currWeather.equals("RAIN"))
			this.coordinates.updateCoordinates(5, 0, 0);
		else if (currWeather.equals("FOG"))
			this.coordinates.updateCoordinates(1, 0, 0);
		else if (currWeather.equals("SNOW"))
			this.coordinates.updateCoordinates(0, 0, -12);
		// Unregister if height is 0
		if (this.coordinates.getHeight() <= 0) {
			this.weatherTower.unregister(this);
			System.out.println("\u001B[1m" + "Tower says: \"Helicopter #" + this.name + " (" + this.id + ") : landing and unregistered from weather tower.\"" + "\u001B[0m");
		}
	}

	@Override
	public void registerTower(WeatherTower p_weatherTower) {
		this.weatherTower = p_weatherTower;
	}
}