package leet.dfs;


/**
 * p200 岛屿数量
 * @author wgq
 * @date 2020/7/14 10:19 上午
 */
public class p200_number_of_islands_dfs {

    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean[][] marked;
    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {

        this.rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        this.cols = grid[0].length;
        this.marked = new boolean[rows][cols];

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;

    }

    private void dfs(char[][] grid, int i, int j) {
        marked[i][j] = true;
        //遍历一个点的四个方向坐标，考虑是否越界
        for (int k = 0; k < 4; k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (inArea(newX, newY) && !marked[newX][newY] && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
        }

    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    public static void main(String[] args) {
        p200_number_of_islands_dfs solution = new p200_number_of_islands_dfs();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int numIslands1 = solution.numIslands(grid1);
        System.out.println(numIslands1);
    }
}
