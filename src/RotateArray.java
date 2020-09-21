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
     * 环状替代法
     * @param nums
     * @param k
     */
    public static void solution3(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        k = k % len;

        for (int start_key = 0; count < k; start_key ++) {
            int current_key = start_key;
            int current_value = nums[current_key];
            do {
                int next_key = (current_key + k) % len; // 当前元素要移动到的下一个位置
                int temp_value = nums[next_key]; // 缓存下来要被替代元素的值
                nums[next_key] = current_value; // 用current_key的值替代要移动到的位置的值
                current_key = next_key; // 移动current_key到新的位置，判断该位置原来的元素要移动到的位置
                current_value = temp_value; // 新的current_value变为被替换下来的值,为下一轮替换做好准备
                count++;
                for (int m = 0; m < nums.length; m++) {
                    System.out.print(nums[m] + ",");
                }
                System.out.println(" ");
            } while (start_key != current_key);
        }
    }
}
