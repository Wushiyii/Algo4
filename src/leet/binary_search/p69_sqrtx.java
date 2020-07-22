package leet.binary_search;

/**
 * p69 - 求平方根
 */
public class p69_sqrtx {

    public int mySqrt(int x) {

        if (x <= 1) {
            return x;
        }

        int left = 1, right = x - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < x / mid) {
                left = mid + 1;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        p69_sqrtx solution = new p69_sqrtx();
//        System.out.println(solution.mySqrt(1));
//        System.out.println(solution.mySqrt(4));
//        System.out.println(solution.mySqrt(9));
        System.out.println(solution.mySqrt(2147395599));
    }
}
