import java.util.*;
public class GraphBipartite {
    static class Solution {
        public int isBipartite(int[][] graph) {
            int n = graph.length;
            int[] color = new int[n];
            for (int i = 0; i < n; i++) {
                if (color[i] != 0)
                    continue;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                color[i] = 1;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int nei : graph[node]) {
                        if (color[nei] == 0) {
                            color[nei] = -color[node];
                            q.offer(nei);
                        } else if (color[nei] == color[node]) {
                            return 0;
                        }
                    }
                }
            }
            return 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][];

        System.out.println("Enter adjacency list for each node:");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number of neighbors for node " + i + ": ");
            int m = sc.nextInt();

            graph[i] = new int[m];
            System.out.print("Enter neighbors: ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int result = sol.isBipartite(graph);

        if (result == 1)
            System.out.println("Graph is Bipartite");
        else
            System.out.println("Graph is NOT Bipartite");

        sc.close();
    }
}