package leet.two_array;

/**
 * 旋转矩阵
 * @author wgq
 * @date 2020/7/10 9:08 下午
 */
public class p0107 {

    public void rotate(int[][] matrix) {

//        matrix[1][0] = matrix[0][2];
//        matrix[1][1] = matrix[1][2];
//        matrix[1][2] = matrix[2][2];
//        matrix[1][3] = matrix[3][2];
//
//        int m = 0, n = 0;

        int n = matrix.length;

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }

        }
    }



}
