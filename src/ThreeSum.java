import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.三数之和
 * https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {
    public static void main(String[] args) {

    }

    /**
     * 排序 + 双指针
     * @param nums
     * @return
     */
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> ans = new ArrayList();

        int len = nums.length;
        // 对原数组排序
        Arrays.sort(nums);

        // 开始遍历
        for (int i = 0; i < len - 2; i++) {
            // 如果nums[i]大于0 可以提前结束了
            if (nums[i] > 0) return ans;
            // 去重
            if (i > 0 && nums[i - 1] == nums[i]) continue;

            // 左指针
            int left = i + 1;
            // 右指针
            int right = len - 1;

            // 开始双指针遍历此层
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) { // 说明左边界太小了，右移left
                    left++;
                } else { // 说明右边界太大了，左移right
                    right--;
                }
            }
        }
        return ans;
    }
}
