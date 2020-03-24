import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StopsFinder extends Finder {

    public StopsFinder(File stopsFile, List<String> stopName) {
        super(stopsFile, stopName);
    }

    @Override
    protected ArrayList<String> find() {
        return null;
    }
    
}
