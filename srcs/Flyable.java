// UML:
// interface Flyable <<Interface>>
// {
//		#WeatherTower weatherTower
//		+abstract void updateConditions()
//		+registerTower(WeatherTower* p_tower)
// }

package srcs;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower p_tower);
}
