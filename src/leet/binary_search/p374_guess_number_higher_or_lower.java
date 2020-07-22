package leet.binary_search;

/**
 * p374 - 猜数字大小
 */
public class p374_guess_number_higher_or_lower {

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res < 0) {
                right = mid - 1;
            } else if (res > 0) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public int guess(int num) {
        return 6 - num;
    }

    public static void main(String[] args) {
        p374_guess_number_higher_or_lower solution = new p374_guess_number_higher_or_lower();
        System.out.println(solution.guessNumber(10));
    }
}
