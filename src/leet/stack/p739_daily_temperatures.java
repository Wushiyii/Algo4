package leet.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author wgq
 * @date 2020/7/16 10:00 上午
 */
public class p739_daily_temperatures {

    public int[] dailyTemperatures(int[] T) {

        if (null == T || T.length == 0) {
            return T;
        }

        int[] res = new int[T.length];
        Arrays.fill(res, 0);
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new int[] {i, T[i]});
            } else {
                while (!stack.isEmpty() && stack.peek()[1] < T[i]) {
                    int[] cur = stack.pop();
                    res[cur[0]] = i - cur[0];
                }
                stack.push(new int[] {i, T[i]});
            }
        }
        return res;
    }

    public static void main(String[] args) {
        p739_daily_temperatures solution = new p739_daily_temperatures();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(solution.dailyTemperatures(T)));
    }

}
