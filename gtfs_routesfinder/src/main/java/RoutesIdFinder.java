import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoutesIdFinder extends Finder {

    public RoutesIdFinder(File tripsFile, List trips) {
        super(tripsFile, trips);
    }

    @Override
    protected List<String> find() {
        List<String> foundResults = new ArrayList<>();

        try {
            Scanner sc = new Scanner(this.file);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String[] tripLine = sc.nextLine().split(",");
                if (!foundResults.contains(tripLine[0]) && this.searched.contains(tripLine[2]))
                    foundResults.add(tripLine[0]);
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

        return foundResults;
    }

}
