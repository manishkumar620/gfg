class Solution {
    int shortestPath(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        // Step 1: mark safe cells
        boolean[][] safe = new boolean[n][m];
        for (boolean[] row : safe) 
            java.util.Arrays.fill(row, true);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    safe[i][j] = false;
                    for (int[] d : dir) {
                        int ni = i + d[0], nj = j + d[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                            safe[ni][nj] = false;
                        }
                    }
                }
            }
        }

        // Step 2: multi-source BFS
        int[][] dist = new int[n][m];
        for (int[] row : dist) 
            java.util.Arrays.fill(row, -1);

        java.util.Queue<int[]> queue = new java.util.LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (safe[i][0]) {
                dist[i][0] = 0;
                queue.offer(new int[]{i, 0});
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            if (y == m - 1) return dist[x][y] + 1;   // <-- FIX: +1 for cell count

            for (int[] d : dir) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m 
                    && safe[nx][ny] && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return -1;
    }
}