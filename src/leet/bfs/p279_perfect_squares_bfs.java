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

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();
        int step = 0;
        visit.add(n);
        queue.offer(n);

        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;

            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();

                // 通过一个循环便利所有小于目标数的平方数
                for (int j = 1; j * j <= n ; j++) {
                    int next = cur - j*j;
                    if (next == 0) {
                        return step;
                    }
                    if (!visit.contains(next)) {
                        queue.add(next);
                    }
                    visit.add(next);
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
