package leet.dfs.practice;


/**
 * @author wgq
 * @date 2020/7/21 9:36 上午
 */
public class p200 {

    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean[][] marked;
    private int rows;
    private int cols;


    public int numIslands(char[][] grid) {
        if (null == grid) {
            return 0;
        }
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        marked = new boolean[rows][cols];

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        marked[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < rows && !marked[newX][newY] && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
        }
    }

    public static void main(String[] args) {
        p200 solution = new p200();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '1', '0', '1', '0'}};
        int numIslands1 = solution.numIslands(grid1);
        System.out.println(numIslands1);
    }
}
