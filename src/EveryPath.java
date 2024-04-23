import java.util.ArrayList;
import java.util.List;

/*
5 (code) Every path [10 points] Write a program that takes as input a directed weighted graph and two of
its vertices, u and w and prints every simple path that goes from u to w with a length of 5.
 */
public class EveryPath {
    static class Edge {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        //  directed weighted graph represented as edges
        List<Edge> graph = new ArrayList<>();
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 3));
        graph.add(new Edge(1, 2, 1));
        graph.add(new Edge(1, 3, 4));
        graph.add(new Edge(2, 3, 5));
        graph.add(new Edge(2, 4, 6));
        graph.add(new Edge(3, 4, 7));

        int u = 0; // source vertex
        int w = 4; // destination vertex
        int pathLength = 5; // required path length

        List<Integer> path = new ArrayList<>();
        path.add(u);
        findPaths(graph, u, w, pathLength, path);
    }

    private static void findPaths(List<Edge> graph, int u, int w, int pathLength, List<Integer> path) {
        if (pathLength == 0 && u == w) {
            System.out.println("Path found: " + path);
            return;
        }
        if (pathLength <= 0)
            return;
        for (Edge edge : graph) {
            if (edge.source == u) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(edge.destination);
                findPaths(graph, edge.destination, w, pathLength - 1, newPath);
            }
        }
    }
}