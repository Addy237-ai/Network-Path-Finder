import java.util.Scanner;

/*
 * Entry point of the Network Path Finder application.
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph();

        System.out.print("Enter CSV file path: ");
        String filePath = sc.nextLine();

        if (!CheckFile.isValidCsv(filePath)) {
            System.out.println("Invalid file. Please provide a valid CSV file.");
            sc.close();
            return;
        }

        try {
            CsvLoader.load(filePath, graph);
            System.out.println("Network loaded successfully.");
            System.out.println("Total nodes: " + graph.getNodes().size());
        } catch (Exception e) {
            System.out.println("Error loading CSV file.");
            sc.close();
            return;
        }

        System.out.println("\nType 'exit' to quit.");

        while (true) {
            System.out.print("\nFROM: ");
            String from = sc.nextLine();
            if (from.equalsIgnoreCase("exit")) break;

            System.out.print("TO:   ");
            String to = sc.nextLine();

            PathInfo result = graph.findPath(from, to);

            if (result != null) {
                System.out.println("\nPath found!");
                System.out.println("Hops: " + result.getHops());
                System.out.println("Visited nodes: " + result.getVisitedNodes());
                System.out.println(String.join(" -> ", result.getPath()));
            } else {
                System.out.println("No path found. Check node names.");
            }
        }

        sc.close();
        System.out.println("Program exited.");
    }
}
