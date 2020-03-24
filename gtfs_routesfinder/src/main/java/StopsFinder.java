import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * StopsFinder Class
 * A StopsFinder finds the stop ids related to the given searched stop name in the GTFS stops file.
 *
 */
public class StopsFinder extends Finder {

    /*
     * StopsFinder constructor
     * Creates a StopsFinder and finds elements related to the searched stop name.
     * @param stopsFile - the specific stops file to use to run the search.
     * @param stopName - the searched stop name we are looking for in the file.
     *
     */
    public StopsFinder(File stopsFile, List<String> stopName) {
        super(stopsFile, stopName);
    }

    /*
     * StopsFinder find method
     * Find the related stop ids for the searched stop name.
     * @return foundElements - the elements found with the given search terms.
     *
     */
    @Override
    protected List<String> find() {
        List<String> foundElements = new ArrayList<>();
        int stopIdLen = 4;

        try {
            Scanner sc = new Scanner(this.file);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String[] stopLine = sc.nextLine().split(",");
                if (stopLine[0].length() == stopIdLen && this.searchedTerms.contains(stopLine[2]))
                    foundElements.add(stopLine[0]);
            }
            sc.close();
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

        return foundElements;
    }

}
