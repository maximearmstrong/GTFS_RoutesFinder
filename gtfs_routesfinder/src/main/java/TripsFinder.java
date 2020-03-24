import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * TripsFinder Class
 * A TripsFinder finds the trip ids related to the given searched stop ids in the GTFS stop times file.
 *
 */
public class TripsFinder extends Finder {

    /*
     * TripsFinder constructor
     * Creates a TripsFinder and finds elements related to the searched stop ids.
     * @param stopTimesFile - the specific stop times file to use to run the search.
     * @param stops - the searched stop ids we are looking for in the file.
     *
     */
    public TripsFinder(File stopTimesFile, List<String> stops) {
        super(stopTimesFile, stops);
    }

    /*
     * TripsFinder find method
     * Find the related trip ids for the searched stop ids.
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
                String[] stopTimeLine = sc.nextLine().split(",");
                if (!foundElements.contains(stopTimeLine[0]) && this.searchedTerms.contains(stopTimeLine[3]))
                    foundElements.add(stopTimeLine[0]);
            }
            sc.close();
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

        return foundElements;
    }

}
