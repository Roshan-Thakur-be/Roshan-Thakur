import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Base case: if 2 or fewer nodes, all are roots of Minimum Height Trees
        if (n <= 2) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }

        // Build adjacency list and compute degrees
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Collect initial leaf nodes (degree == 1)
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // Trim leaves layer by layer until <= 2 nodes remain
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for (int leaf : leaves) {
                // Get the unique neighbor of the current leaf
                int neighbor = adj.get(leaf).iterator().next();
                
                // Remove the leaf edge from neighbor's adjacency set
                adj.get(neighbor).remove(leaf);

                // If neighbor becomes a new leaf, add to the next layer
                if (adj.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }

            leaves = newLeaves;
        }

        return leaves;
    }
}