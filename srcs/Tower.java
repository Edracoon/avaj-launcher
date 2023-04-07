// UML:
// class Tower
// {
//		- List<Flyable*> observers
//		+void register(Flyable* p_flyable)
//		+void unregister(Flyable* p_flyable)
//		#void conditionChanged()
// }
package srcs;
import java.util.ArrayList;
import java.util.List;

public class Tower {
	static private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged() {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).updateConditions();
		}
	}
}