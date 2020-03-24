import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Finder {

    protected File file;
    protected List<String> searched;
    protected List<String> foundResults;

    public Finder(File file, List<String> searched) {
        this.file = file;
        this.searched = searched;
        this.foundResults = find();
    }

    public List<String> getFound() {
        return this.foundResults;
    }

    public String toString() {
        return String.join(", ", this.foundResults);
    }

    abstract protected List<String> find();

}
