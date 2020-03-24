import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class Finder {

    private File file;
    private List<String> searched;
    private List<String> foundResults;

    public Finder(File file, List<String> searched) {
        this.file = file;
        this.searched = searched;
        this.foundResults = find();
    }

    abstract protected ArrayList<String> find();

}
