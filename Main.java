import srcs.Data;
import srcs.Coordinates;

public class Main {

    public static void main(String[] args) {
        Data    data = new Data();

        if (args.length != 1) {
            System.err.println("Usage: java Main <filename>");
            System.exit(1);
        }

        String filename = args[0];

        data.parseFile(filename);
    }
}
