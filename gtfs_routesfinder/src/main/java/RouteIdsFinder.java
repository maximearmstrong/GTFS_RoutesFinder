import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * RouteIdsFinder Class
 * A RouteIdsFinder finds the route ids related to the given searched trip ids in the GTFS trips file.
 *
 */
public class RouteIdsFinder extends Finder {

    /*
     * RouteIdsFinder constructor
     * Creates a RouteIdsFinder and finds elements related to the searched trip ids.
     * @param tripsFile - the specific trips file to use to run the search.
     * @param trips - the searched trips ids we are looking for in the file.
     *
     */
    public RouteIdsFinder(File tripsFile, List trips) {
        super(tripsFile, trips);
    }

    /*
     * RouteIdsFinder find method
     * Find the related route ids for the searched trip ids.
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
                String[] tripLine = sc.nextLine().split(",");
                if (!foundElements.contains(tripLine[0]) && this.searchedTerms.contains(tripLine[1]))
                    foundElements.add(tripLine[0]);
            }
            sc.close();
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

        return foundElements;
    }

}
