class Solution {
    
    private int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) dfs(heights, pacific, i, 0);
        for (int j = 0; j < n; j++) dfs(heights, pacific, 0, j);

        for (int i = 0; i < m; i++) dfs(heights, atlantic, i, n - 1);
        for (int j = 0; j < n; j++) dfs(heights, atlantic, m - 1, j);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int r, int c) {
        if (visited[r][c]) return;
        visited[r][c] = true;

        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr < 0 || nr >= heights.length || nc < 0 || nc >= heights[0].length) continue;
            if (heights[nr][nc] < heights[r][c]) continue; 
            dfs(heights, visited, nr, nc);
        }
    }
}
