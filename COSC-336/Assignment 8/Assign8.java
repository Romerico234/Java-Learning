import java.util.*;

public class Assign8 {
    public static void main(String[] args) {
        Adj_List_Graph g1 = new Adj_List_Graph(7 + 1);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(1, 4);
        g1.addEdge(2, 5);
        g1.addEdge(3, 5);
        g1.addEdge(4, 6);
        g1.addEdge(5, 7);
        g1.addEdge(6, 7);

        Adj_List_Graph g2 = new Adj_List_Graph(10 + 1); 
        g2.addEdge(1, 2);
        g2.addEdge(1, 3);
        g2.addEdge(1, 4);
        g2.addEdge(1, 5);
        g2.addEdge(1, 6);
        g2.addEdge(2, 7);
        g2.addEdge(3, 7);
        g2.addEdge(4, 7);
        g2.addEdge(5, 7);
        g2.addEdge(6, 7);
        g2.addEdge(7, 8);
        g2.addEdge(7, 9);
        g2.addEdge(8, 10);
        g2.addEdge(9, 10);

        modifiedBFS(g1, 1);
        System.out.println("------------------------------");
        modifiedBFS(g2, 1);
    }

    public static void modifiedBFS(Adj_List_Graph g, int s) {
        int n = g.n;
        int[] dist = new int[n];
        int[] npath = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(npath, 0);
        Queue<Integer> queue = new LinkedList<>();
        dist[s] = 0;
        npath[s] = 1;
        queue.add(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : g.adj.get(u)) {
                if (dist[v] == Integer.MAX_VALUE) { // v has not been visited
                    dist[v] = dist[u] + 1;
                    npath[v] = npath[u];
                    queue.add(v);
                } else if (dist[v] == dist[u] + 1) // Another shortest path found
                    npath[v] += npath[u];
            }
        }

        for (int i = 1; i < n; i++)
            System.out.println("Vertex " + i + ": dist = " + dist[i] + ", npath = " + npath[i]);
    }
}
