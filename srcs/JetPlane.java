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
		System.out.println("-> JetPlane " + this.name + " - " + currWeather);
		if (currWeather.equals("SUN")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude() + 10,
				this.coordinates.getHeight() + 2
			);
		}
		else if (currWeather.equals("RAIN")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude() + 5,
				this.coordinates.getHeight()
			);
		}
		else if (currWeather.equals("FOG")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude() + 1,
				this.coordinates.getHeight()
			);
		}
		else if (currWeather.equals("SNOW")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 7
			);
		}
		// Unregister if height is 0
		if (this.coordinates.getHeight() <= 0) {
			this.weatherTower.unregister(this);
			System.out.println("JetPlane #" + this.name + "(" + this.id + "): landing.");
			System.out.println("Tower says: JetPlane #" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
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