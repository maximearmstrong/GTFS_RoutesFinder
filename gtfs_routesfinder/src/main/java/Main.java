import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StopsFinder stops = new StopsFinder(new File(args[0]+"/stops.txt"), Arrays.asList(args[1]));
        TripsFinder trips = new TripsFinder(new File(args[0]+"/stop_times.txt"), stops.getFound());
        RouteIdsFinder routesId = new RouteIdsFinder(new File(args[0]+"/trips.txt"), trips.getFound());
        RouteNamesFinder routesName = new RouteNamesFinder(new File(args[0]+"/routes.txt"), routesId.getFound());
        System.out.println("Les lignes de métro qui passent par " + args[1] + " sont : " + routesName.toString());
    }
}
