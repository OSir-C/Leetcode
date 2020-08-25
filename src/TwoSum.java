import java.util.HashMap;
import java.util.Map;

/**
 * 1 两数之和
 * https://leetcode-cn.com/problems/two-sum/solution/
 *
 * 三种办法：
 *  暴力法
 *  两遍hash
 *  一遍hash
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 5, 6, 12};

    }

    /**
     * 暴力法
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 两遍哈希法
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); // 形成字典，注意num[i]放在了key中
        }

        for (int j = 0; j < nums.length; j++) {
            int complement = target - nums[j];
            if (map.containsKey(complement) && (map.get(complement) != j)) {
                return new int[]{j, map.get(complement)}; // 注意先后顺序
            }
        }

        return new int[]{};
    }

    /**
     * 一遍哈希法
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // 在写入字典之前，先检查字典中是否已经存在该key
            // 如果已经存在，则直接返回
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
