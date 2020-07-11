package leet.two_array;

import java.util.*;

/**
 * 零矩阵
 * @author wgq
 * @date 2020/7/11 12:27 上午
 */
public class p0108 {

    public static void setZeroes(int[][] matrix) {

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }


        for (Integer row : rows) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = 0;
            }
        }


        for (Integer col : cols) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = 0;
            }
        }

    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};

        setZeroes(matrix);
    }


}
