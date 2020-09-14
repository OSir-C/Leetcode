/**
 * 283 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZero {
    public static void main(String[] args) {

    }

    /**
     * 双指针法
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public static void solution1(int[] nums) {
        int last = 0;
        // 第一遍，将所有非0元素前移
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[last++] = nums[i];
            }
        }

        // 第二遍给last之后的元素赋值为0
        for (int i = last; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 双指针（更快）
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param nums
     * @return
     */
    public static void solution2(int[] nums) {
        for (int cur = 0, last = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                int tmp = nums[cur];
                nums[cur] = nums[last];
                nums[last++] = tmp;
            }
        }
    }
}
