/**
 * 66 加一
 * https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne {
    public static void main(String[] args) {

    }

    public static int[] solution(int[] digits) {
        int len = digits.length;

        for (int i = len -1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;

            if (digits[i] != 0) return digits;
        }

        // 如果所有的位数都为0，长度加一，首位是1，比如 99 -> 100
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}