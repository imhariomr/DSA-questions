import java.util.*;

public class PrimsAlgo {

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

    public static class Pair implements Comparable<Pair> {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.weight - p2.weight;
        }
    }

    public static void PrimsAlgo(ArrayList<Edge> graph[]) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[graph.length];
        int cost = 0;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                cost += curr.weight;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    pq.add(new Pair(e.destination, e.weight));
                }
            }
        }

        System.out.println(cost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 3, 50));

        PrimsAlgo(graph);
    }
}
