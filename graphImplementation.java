import java.util.*;

public class graphImplementation {
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

    public static void BFS(ArrayList<Edge> graph[]) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.println(curr);
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.destination);
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.println(curr);
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.destination]) {
                DFS(graph, e.destination, vis);
            }
        }
    }

    public static void printAllPath(ArrayList<Edge> graph[], int curr, boolean vis[], int scr, int tar, String path) {
        if (curr == tar) {
            System.out.println(path);
            return;
        }

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[curr]) {
                vis[curr] = true;
                printAllPath(graph, e.destination, vis, scr, tar, path + e.destination);
                vis[curr] = false;
            }
        }
    }

    public static boolean cycleDetection(ArrayList<Edge> graph[], int curr, boolean vis[], boolean rec[]) {
        vis[curr] = true;
        rec[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.destination]) {
                if (rec[e.destination] == true) {
                    return true;
                } else if (cycleDetection(graph, e.destination, vis, rec)) {
                    return true;
                }
            }
        }

        rec[curr] = false;
        return false;
    }

    public static void toplogicalHelper(ArrayList<Edge> graph[], Stack<Integer> s, int curr, boolean vis[]) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.destination]) {
                toplogicalHelper(graph, s, e.destination, vis);
            }
        }
        s.push(curr);
    }

    public static void toplogicalSort(ArrayList<Edge> graph[]) {
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                toplogicalHelper(graph, s, i, vis);
            }
        }

        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static boolean cycleUndirected(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.destination] && e.destination != par) {
                return true;
            } else if (cycleUndirected(graph, vis, e.destination, curr)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 0));
        graph[1].add(new Edge(1, 2, 0));
        graph[1].add(new Edge(1, 3, 0));
        graph[2].add(new Edge(2, 4, 0));
        graph[3].add(new Edge(3, 4, 0));
        graph[4].add(new Edge(4, 5, 0));

        // for (int i = 0; i < graph[2].size(); i++) {
        // Edge e = graph[2].get(i);
        // System.out.println(e.destination);
        // }

        // BFS(graph);
        // DFS(graph, 0, new boolean[v]);
        // printAllPath(graph, 0, new boolean[v], 0, 5, "0");
        // System.out.println(cycleDetection(graph, 0, new boolean[v], new boolean[v]));
        // toplogicalSort(graph);
        System.out.println(cycleUndirected(graph, new boolean[v], 0, -1));
    }
}