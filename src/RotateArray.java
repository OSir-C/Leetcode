/**
 * 189.旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class RotateArray {
    public static void main(String[] args) {
        //int[] testArr = new int[]{1,2,3,4,5,6,7};
        //int[] testArr = new int[]{-1,-100,3,99};
        int[] testArr = new int[]{1, 2, 3, 4, 5, 6};
        solution3(testArr, 2);
    }

    /**
     * 暴力解法
     * 时间复杂度 O(k * N)
     * 空间复杂度 O(1)
     * @param nums
     * @param k
     */
    public static void solution1(int[] nums, int k) {
        int len = nums.length;
        k = k % len; // 实际要移动的k

        for (int i = 0; i < k; i++) {
            int last = nums[len - 1]; // 记录最后一位的值
            for (int j = len - 1; j > 0; j--) { // 开始每一位后移1位
                nums[j] = nums[j-1];
            }
            nums[0] = last; // 最后一位赋值给第一位
        }
    }

    /**
     * 三次反转法
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     * @param nums
     * @param k
     */
    public static void solution2(int[] nums, int k) {
        int len = nums.length;
        k = k % len;

        if (k < 1) return; // 注意这个边界条件

        // 先将整个数组反转
        reverse(nums, 0, len - 1);

        // 将前n个元素反转
        reverse(nums, 0, k - 1);

        // 将后边n-k个元素反转
        reverse(nums, k, len - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    /**
     * 一次性移动到位
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     * @param nums
     * @param k
     */
    public static void solution3(int[] nums, int k) {
        int len = nums.length;
        k = k % len; // 实际要移动的步数
        int count = 0; // 记录总的移动步数

        for (int start_key = 0; count < len; start_key++) {
            int current_key = start_key;
            int current_val = nums[current_key];

            do {
                int next_key = (current_key + k) % len;
                int tmp_val = nums[next_key];
                nums[next_key] = current_val;
                current_key = next_key;
                current_val = tmp_val;
                count++;
            } while (start_key != current_key);
        }
    }
}
