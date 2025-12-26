import java.util.List;

/*
 * PathInfo stores the result of a path search.
 */
public class PathInfo {

    private List<String> path;
    private int hops;
    private int visitedNodes;

    public PathInfo(List<String> path, int visitedNodes) {
        this.path = path;
        this.hops = path.size() - 1;
        this.visitedNodes = visitedNodes;
    }

    public List<String> getPath() {
        return path;
    }

    public int getHops() {
        return hops;
    }

    public int getVisitedNodes() {
        return visitedNodes;
    }
}
