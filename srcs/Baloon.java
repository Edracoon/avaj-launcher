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
		System.out.println("-> Baloon " + this.name + " - " + currWeather);
		if (currWeather.equals("SUN")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude() + 2,
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() + 4
			);
		}
		else if (currWeather.equals("RAIN")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 5
			);
		}
		else if (currWeather.equals("FOG")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 3
			);
		}
		else if (currWeather.equals("SNOW")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 15
			);
		}
		// Unregister if height is 0
		if (this.coordinates.getHeight() <= 0) {
			this.weatherTower.unregister(this);
			System.out.println("Baloon #" + this.name + "(" + this.id + "): landing.");
			System.out.println("Tower says: Baloon #" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
		}
		// Restrict height to 100
		if (this.coordinates.getHeight() > 100) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				100
			);
		}
	}

	@Override
	public void registerTower(WeatherTower p_weatherTower) {
		this.weatherTower = p_weatherTower;
	}
}