import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TripsFinder extends Finder {

    public TripsFinder(File stopTimesFile, List<String> stops) {
        super(stopTimesFile, stops);
    }

    @Override
    protected ArrayList<String> find() {
        return null;
    }

}
