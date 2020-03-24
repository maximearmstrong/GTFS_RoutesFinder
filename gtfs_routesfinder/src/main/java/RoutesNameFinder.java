import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoutesNameFinder extends Finder {

    public RoutesNameFinder(File routesFile, List routes) {
        super(routesFile, routes);
    }

    @Override
    protected List<String> find() {
        List<String> foundResults = new ArrayList<>();

        try {
            Scanner sc = new Scanner(this.file);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String[] routeLine = sc.nextLine().split(",");
                if (this.searched.contains(routeLine[0]))
                    foundResults.add(routeLine[2]);
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

        return foundResults;
    }

}
