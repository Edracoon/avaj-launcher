import srcs.Data;
import srcs.WeatherTower;

public class Main {

    public static WeatherTower weatherTower = new WeatherTower();

    public static void main(String[] args) {
        Data    data = new Data();

        if (args.length != 1) {
            System.err.println("Usage: java Main <filename>");
            System.exit(1);
        }

        String filename = args[0];

        data.parseFile(filename, weatherTower);

        for (int i = 0; i < data.simulations; i++) {
            System.out.println("\u001B[32m--- Simulation " + (i + 1) + " started ---\u001B[0m");
            weatherTower.changeWeather();
        }

        System.out.println("Simulation finished");
    }
}
