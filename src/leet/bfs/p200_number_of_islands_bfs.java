package leet.bfs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * p200 岛屿数量 - BFS解法
 * @author wgq
 * @date 2020/7/14 10:19 上午
 */
public class p200_number_of_islands_bfs {

    private int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0 ,1}};
    private boolean[][] marked;
    private int rows;
    private int cols;
    private Queue<int[]> queue;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        marked = new boolean[rows][cols];
        queue = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    marked[i][j] = true;
                    count++;
                    queue.add(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];

                        for (int k = 0; k < 4; k++) {
                            int newX = x + directions[k][0];
                            int newY = y + directions[k][1];

                            if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                                marked[newX][newY] = true;
                                queue.add(new int[] {newX, newY});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static void main(String[] args) {
        p200_number_of_islands_bfs solution = new p200_number_of_islands_bfs();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '1'}};
        int numIslands1 = solution.numIslands(grid1);
        System.out.println(numIslands1);
    }

}
