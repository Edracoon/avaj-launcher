package srcs;

// ◦ SUN - Longitude increases with 2, Height increases with 4
// ◦ RAIN - Height decreases with 5
// ◦ FOG - Height decreases with 3
// ◦ SNOW - Height decreases with 15

public class Baloon extends Aircraft implements Flyable {
    protected WeatherTower weatherTower;

	public Baloon(String p_name, Coordinates p_coordinate) {
		super(p_name, p_coordinate);
	}

	@Override
	public void updateConditions() {
		String currWeather = this.weatherTower.getWeather(coordinates);
		System.out.println("Baloon #" + this.name + " (" + this.id + ") has " + currWeather);
		if (currWeather.equals("SUN")) 
			this.coordinates.updateCoordinates(2, 0, 4);
		else if (currWeather.equals("RAIN"))
			this.coordinates.updateCoordinates(0, 0, -5);
		else if (currWeather.equals("FOG"))
			this.coordinates.updateCoordinates(0, 0, -3);
		else if (currWeather.equals("SNOW"))
			this.coordinates.updateCoordinates(0, 0, -15);

		// Unregister if height is 0
		if (this.coordinates.getHeight() <= 0) {
			this.weatherTower.unregister(this);
			System.out.println("\u001B[1m" + "Tower says: \"Baloon #" + this.name + " (" + this.id + ") landing and unregistered from weather tower.\"" + "\u001B[0m");
		}
	}

	@Override
	public void registerTower(WeatherTower p_weatherTower) {
		this.weatherTower = p_weatherTower;
	}
}