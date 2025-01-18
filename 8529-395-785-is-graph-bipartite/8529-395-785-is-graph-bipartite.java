import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length; // Number of vertices
        int[] colors = new int[n]; // 0: uncolored, 1: first set, -1: second set

        // Check each component of the graph
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) { // If the node is not yet colored
                // Start BFS from node i
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                colors[i] = 1; // Color the starting node with 1

                while (!queue.isEmpty()) {
                    int node = queue.poll();

                    for (int neighbor : graph[node]) {
                        if (colors[neighbor] == 0) {
                            // If the neighbor is not colored, assign the opposite color
                            colors[neighbor] = -colors[node];
                            queue.offer(neighbor);
                        } else if (colors[neighbor] == colors[node]) {
                            // If the neighbor has the same color, the graph is not bipartite
                            return false;
                        }
                    }
                }
            }
        }

        return true; // If no conflicts were found, the graph is bipartite
    }
}
