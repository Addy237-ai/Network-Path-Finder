import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * CsvLoader reads network connections from a CSV file
 * and loads them into the graph.
 */
public class CsvLoader {

    public static void load(String filePath, Graph graph) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(filePath));

        br.lines()
          .map(line -> line.split(","))
          .filter(parts -> parts.length == 2)
          .forEach(parts -> graph.addEdge(parts[0], parts[1]));

        br.close();
    }
}

