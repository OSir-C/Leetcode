/**
 * 70 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(solution1(5));
    }

    /**
     * 递归法
     * 时间复杂度
     * 空间复杂度
     * @param n
     * @return
     */
    public static int solution1(int n) {
        if (n <= 2) return n;
        return solution1(n - 2) + solution1(n - 1);
    }

    /**
     * 有缓存的递归
     * @TODO 待完善
     * 时间复杂度
     * 空间复杂度
     * @param n
     * @return
     */
    public static int solution2(int n) {
        return n;
    }

    /**
     * 动态规划
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param n
     * @return
     */
    public static int solution3(int n) {
        if (n <= 2) return n;

        int p = 1, q = 2, ans = 0;

        for (int i = 2; i < n; i++) {
            // 结果就是前两级台阶走法相加
            ans = p + q;
            
            // 后移
            p = q;
            q = ans;
        }
        return ans;
    }
}
