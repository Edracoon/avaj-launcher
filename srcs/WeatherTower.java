// class WeatherTower
// {
// +string getWeather(Coordinates p_coordinates)
// +void changeWeather()
// }
package srcs;

public class WeatherTower extends Tower
{
	public String getWeather(Coordinates p_coordinates)
	{
		WeatherProvider weatherProvider = WeatherProvider.getProvider();
		String currentWeather = weatherProvider.getCurrentWeather(p_coordinates);
		return currentWeather;
	}

	public void changeWeather()
	{
		conditionsChanged();
	}
}
