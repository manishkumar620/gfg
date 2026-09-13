class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        if (n <= 1) return 0;

        // adj is 0-indexed (adj.get(i) = neighbors of house i+1, 1-indexed values).
        // Rebuild into a 1-indexed graph of size n+1 for cleaner BFS.
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int neighbor : adj.get(i)) {
                graph.get(i + 1).add(neighbor);
            }
        }

        // Step 1: BFS from house 1 to find one end of the diameter
        int[] dist1 = new int[n + 1];
        int A = bfs(1, graph, n, dist1);

        // Step 2: BFS from A to find the other end and the diameter length
        int[] dist2 = new int[n + 1];
        int B = bfs(A, graph, n, dist2);

        int diameter = dist2[B];

        // Step 3: minimum eccentricity = ceil(diameter / 2)
        return (diameter + 1) / 2;
    }

    // BFS that fills dist[] and returns the farthest node from src
    private int bfs(int src, List<List<Integer>> graph, int n, int[] dist) {
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        dist[src] = 0;
        queue.add(src);
        int farthestNode = src;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + 1;
                    if (dist[neighbor] > dist[farthestNode]) {
                        farthestNode = neighbor;
                    }
                    queue.add(neighbor);
                }
            }
        }
        return farthestNode;
    }
}