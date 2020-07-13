package leet.two_array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgq
 * @date 2020/7/13 2:52 下午
 */
public class p118 {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        if (numRows == 0) {
            return res;
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            if (i == 0) {
                row.add(1);
                res.add(row);
                continue;
            }
            if (i == 1) {
                row.add(1);
                row.add(1);
                res.add(row);
                continue;
            }
            row.add(1);
            for (int j = 1; j < i ; j++) {
                row.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
