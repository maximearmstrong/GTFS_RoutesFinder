import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * RouteNamesFinder Class
 * A RouteNamesFinder finds the route names related to the given searched route ids in the GTFS routes file.
 *
 */
public class RouteNamesFinder extends Finder {

    /*
     * RouteNamesFinder constructor
     * Creates a RouteNamesFinder and finds elements related to the searched route ids.
     * @param routesFile - the specific routes file to use to run the search.
     * @param routes - the searched route ids we are looking for in the file.
     *
     */
    public RouteNamesFinder(File routesFile, List routes) {
        super(routesFile, routes);
    }

    /*
     * RouteNamesFinder find method
     * Find the related route names for the searched route ids.
     * @return foundElements - the elements found with the given search terms.
     *
     */
    @Override
    protected List<String> find() {
        List<String> foundElements = new ArrayList<>();

        try {
            Scanner sc = new Scanner(this.file);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String[] routeLine = sc.nextLine().split(",");
                if (this.searchedTerms.contains(routeLine[0]))
                    foundElements.add(routeLine[2]);
            }
            sc.close();
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

        return foundElements;
    }

}
