package leet.union;


/**
 * p200 岛屿数量 并查集实现
 * @author wgq
 * @date 2020/7/14 10:19 上午
 */
public class p200_number_of_islands_union {

    private int[][] directions = {{0, 1}, {1, 0}};

    public int numIslands(char[][] grid) {

        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;
        int size = rows * cols;

        // +1 是认为虚拟的水域
        UnionFind uf = new UnionFind(size + 1);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果为陆地，则将陆地接壤的节点都并在一起
                if (grid[i][j] == '1') {
                    for (int[] direction : directions) {
                        int newX = i + direction[0];
                        int newY = j + direction[1];
                        if (newX < rows && newY < cols && grid[newX][newY] == '1') {
                            uf.union(cols * i + j, cols * newX + newY);
                        }
                    }
                } else {
                    //如果是水域，则将水域与虚拟节点并在一起
                    uf.union(cols * i + j, size);
                }
            }
        }

        return uf.count - 1;

    }

    class UnionFind {
        private int[] parent;
        private int count;


        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        /**
         * 返回索引为 p 的元素的根结点
         */
        public int find(int p) {
            while (p != parent[p]) {
                p = parent[p];
            }
            return p;
        }

        public boolean connected(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            return pRoot == qRoot;
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            parent[qRoot] = pRoot;
            count--;
        }


    }

    public static void main(String[] args) {
        p200_number_of_islands_union solution = new p200_number_of_islands_union();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '1'}};
        int numIslands1 = solution.numIslands(grid1);
        System.out.println(numIslands1);
    }
}
