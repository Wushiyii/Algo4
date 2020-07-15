package leet.bfs;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * p279 - 完全平方数 BFS
 * @author wgq
 * @date 2020/7/14 6:07 下午
 */
public class p279_perfect_squares_bfs {

    public int numSquares(int n) {

        Set<Integer> visit = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int step = 0;

        queue.add(n);
        visit.add(n);

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                for (int j = 0; j*j <= n; j++) {
                    int left = cur - j*j;
                    if (left == 0) {
                        return step;
                    }
                    if (!visit.contains(left)) {
                        queue.add(left);
                        visit.add(left);
                    }
                }
            }
        }
        return step;

    }


    public static void main(String[] args) {
        p279_perfect_squares_bfs s = new p279_perfect_squares_bfs();
        System.out.println(s.numSquares(4));
        System.out.println(s.numSquares(12));
        System.out.println(s.numSquares(13));
    }
}
