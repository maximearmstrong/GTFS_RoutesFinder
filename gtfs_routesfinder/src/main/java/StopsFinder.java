import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StopsFinder extends Finder {

    public StopsFinder(File stopsFile, List<String> stopName) {
        super(stopsFile, stopName);
    }

    @Override
    protected List<String> find() {
        List<String> foundResults = new ArrayList<>();
        int stopIdLen = 4;

        try {
            Scanner sc = new Scanner(this.file);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String[] stopLine = sc.nextLine().split(",");
                if (stopLine[0].length() == stopIdLen && this.searched.contains(stopLine[2]))
                    foundResults.add(stopLine[0]);
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

        return foundResults;
    }

}
