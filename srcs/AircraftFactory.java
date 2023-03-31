package srcs;

/*
 * AircraftFactory << Singleton >>
 * To create a singleton class, we need to do the following:
 * -> Make the constructor private
 * -> Create a public static method that returns the instance of the class
 * -> Create a private static variable of the instance of the class
 * To make sure that only one instance of the class is created in the entire program.
 * (Not multi thread safe)
 */
class AircraftFactory
{
	private static AircraftFactory instance = null;

	private AircraftFactory() {}

	public static AircraftFactory getInstance() {
		if (instance == null)
			instance = new AircraftFactory();
		return instance;
	}

	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		if (type.equals("Baloon"))
			return new Baloon(name, coordinates);
		else if (type.equals("Helicopter"))
			return new Helicopter(name, coordinates);
		else if (type.equals("JetPlane"))
			return new JetPlane(name, coordinates);
		return null;
	}
}