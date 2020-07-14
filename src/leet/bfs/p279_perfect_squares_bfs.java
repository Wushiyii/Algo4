package leet.bfs;

import java.util.*;

/**
 * p279 - 完全平方数 BFS
 * @author wgq
 * @date 2020/7/14 6:07 下午
 */
public class p279_perfect_squares_bfs {

    public int numSquares(int n) {
        if (n <= 0) {
            return n;
        }

        // 获取目标数下的平方数
        List<Integer> squares = getSquares(n);
        // mark集合
        Set<Integer> visit = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int step = 0;

        queue.offer(n);
        visit.add(n);

        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                for (Integer square : squares) {
                    int next = cur - square;

                    if (!visit.contains(next)) {
                        if (next < 0) {
                            break;
                        }
                        if (next == 0) {
                            return step;
                        }
                        visit.add(next);
                        queue.offer(next);
                    }

                }
            }
        }

        return n;

    }

    private static List<Integer> getSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i < n ; i++) {
            squares.add(i*i);
        }
        return squares;
    }


    public static void main(String[] args) {
        p279_perfect_squares_bfs s = new p279_perfect_squares_bfs();
//        System.out.println(s.numSquares(5));
        System.out.println(s.numSquares(12));
//        System.out.println(s.numSquares(13));
    }
}
