import java.util.ArrayList;

public class bellmanFord {

    public static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int scr, int des, int wt) {
            this.source = scr;
            this.destination = des;
            this.weight = wt;
        }
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int scr) {
        int[] dist = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[scr] = 0;

        for (int k = 0; k < graph.length - 1; k++) {

            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.source;
                    int v = e.destination;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[v]) {
                        dist[v] = dist[u] + e.weight;
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1));

        bellmanFord(graph, 0);
    }
}
