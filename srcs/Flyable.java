package srcs;

public interface Flyable {
	protected WeatherTower weatherTower = new WeatherTower();

	abstract void updateConditions();
    void registerTower(WeatherTower weatherTower);
}
