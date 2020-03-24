import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TripsFinder extends Finder {

    public TripsFinder(File stopTimesFile, List<String> stops) {
        super(stopTimesFile, stops);
    }

    @Override
    protected List<String> find() {
        List<String> foundResults = new ArrayList<>();

        try {
            Scanner sc = new Scanner(this.file);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String[] stopTimeLine = sc.nextLine().split(",");
                if (!foundResults.contains(stopTimeLine[0]) && this.searched.contains(stopTimeLine[3]))
                    foundResults.add(stopTimeLine[0]);
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

        return foundResults;
    }

}
