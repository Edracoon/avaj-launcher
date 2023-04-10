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
		System.out.println("-> Helicopter " + this.name + " - " + currWeather);
		if (currWeather.equals("SUN")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude() + 10,
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() + 2
			);
		}
		else if (currWeather.equals("RAIN")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude() + 5,
				this.coordinates.getLatitude(),
				this.coordinates.getHeight()
			);
		}
		else if (currWeather.equals("FOG")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude() + 1,
				this.coordinates.getLatitude(),
				this.coordinates.getHeight()
			);
		}
		else if (currWeather.equals("SNOW")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 12
			);
		}
		// Unregister if height is 0
		if (this.coordinates.getHeight() <= 0) {
			this.weatherTower.unregister(this);
			System.out.println("Helicopter #" + this.name + "(" + this.id + "): landing.");
			System.out.println("Tower says: Helicopter #" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
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