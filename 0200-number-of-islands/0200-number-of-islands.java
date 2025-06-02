class Solution {
    private void dfs(int row, int col, boolean[][] visited, char[][] grid, int n, int m) {
        visited[row][col] = true;

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                    && !visited[nRow][nCol] && grid[nRow][nCol] == '1')
                dfs(nRow, nCol, visited, grid, n, m);
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int ct = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ct++;
                    dfs(i, j, visited, grid, n, m);
                }
            }
        }
        return ct;

    }
}