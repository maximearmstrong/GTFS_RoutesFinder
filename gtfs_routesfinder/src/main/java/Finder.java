import java.io.File;
import java.util.List;

/*
 * Finder Abstract Class
 * A Finder finds the elements related to the given searched terms in a specific file.
 * Ex. A StopsFinder finds the stop ids related to the given
 *     searched stop name in the GTFS stops file.
 *
 */
public abstract class Finder {

    protected File file;
    protected List<String> searchedTerms;
    protected List<String> foundElements;

    /*
     * Finder constructor
     * Creates a Finder and finds elements related to the searched terms.
     * @param file - the specific file to use to run the search.
     * @param searchedTerms - the searched terms we are looking for in the file.
     *
     */
    public Finder(File file, List<String> searched) {
        this.file = file;
        this.searchedTerms = searched;
        this.foundElements = find();
    }

    /*
     * Found elements getter
     * Gets the found elements for this finder.
     * @return foundElements - the elements found for this finder.
     *
     */
    public List<String> getFound() {
        return this.foundElements;
    }

    /*
     * Finder toString
     * Creates a string for the found elements of this finder.
     * @return foundElements - the elements found for this finder.
     *
     */
    public String toString() {
        return String.join(", ", this.foundElements);
    }

    /*
     * Abstract find method
     * To be implemented in each sub-class.
     *
     */
    abstract protected List<String> find();

}
