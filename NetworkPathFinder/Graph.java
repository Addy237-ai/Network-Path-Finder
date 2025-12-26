import java.util.*;
public class Graph {

    // Adjacency list: node -> list of connected nodes
    private Map<String, List<String>> adjList = new HashMap<>();

    // Adds a two-way connection between nodes
    public void addEdge(String from, String to) {
        from = from.trim().toUpperCase();
        to = to.trim().toUpperCase();

        adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        adjList.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
    }

    // Finds shortest path using BFS
    public PathInfo findPath(String start, String end) {
        start = start.toUpperCase();
        end = end.toUpperCase();

        if (!adjList.containsKey(start) || !adjList.containsKey(end)) {
            return null;
        }

        Queue<List<String>> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.add(List.of(start));
        visited.add(start);

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String lastNode = path.get(path.size() - 1);

            if (lastNode.equals(end)) {
                return new PathInfo(path, visited.size());
            }

            adjList.get(lastNode).stream()
                   .filter(n -> !visited.contains(n))
                   .forEach(n -> {
                       visited.add(n);
                       List<String> newPath = new ArrayList<>(path);
                       newPath.add(n);
                       queue.add(newPath);
                   });
        }

        return null;
    }

    public Set<String> getNodes() {
        return adjList.keySet();
    }
}

