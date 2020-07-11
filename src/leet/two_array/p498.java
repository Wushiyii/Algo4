package leet.two_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * p498 - 对角线遍历
 * @author wgq
 * @date 2020/7/11 1:18 下午
 */
public class p498 {

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int N = matrix.length;
        int M = matrix[0].length;

        // 结果一共是N * M 个数字
        int[] result = new int[N * M];

        // 存放结果的索引
        int index = 0;

        // 存放每条斜边，循环一次就清除
        List<Integer> list = new ArrayList<>();

        for (int d = 0; d < N + M - 1; d++) {

            list.clear();

            // 当d索引未移动到最大列数时，d就为第一行， 超过时为 d - 最大列数索引 (M - 1)
            int row = d < M ? 0 : d - M + 1;

            // 当d
            int col = d < M ? d : M - 1;

            while (col > -1 && row < N) {
                list.add(matrix[row][col]);
                ++row;
                --col;
            }

            if (d % 2 == 0) {
                Collections.reverse(list);
            }

            for (int i = 0; i < list.size(); i++) {
                result[index++] = list.get(i);
            }

        }
        return result;

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int[] res = findDiagonalOrder(matrix);
        System.out.println(Arrays.toString(res));

    }

}
