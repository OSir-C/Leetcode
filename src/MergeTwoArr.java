import java.util.Arrays;

/**
 * 88.合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class MergeTwoArr {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 4, 5, 0, 0, 0};
        int[] nums2 = new int[]{2, 3, 4};

        solution1(nums1, 4, nums2, 3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ",");
        }
    }

    /**
     * 合并后排序
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public static int[] solution1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        return nums1;
    }

    /**
     * 双指针（从前往后）
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public static int[] solution2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[nums1.length]; // 开辟新数组
        System.arraycopy(nums1, 0, nums3, 0, m);

        // 声明指针，分别代表nums1,nums2,nums3下标
        int p1 = 0, p2 = 0, p = 0;

        while(p1 < m && p2 < n) {
            nums1[p++] = (nums3[p1] < nums2[p2]) ? nums3[p1++] : nums2[p2++];
        }

        if (p1 < m) System.arraycopy(nums3, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n) System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);

        return nums1;
    }

    /**
     * 双指针（从后往前）
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public static int[] solution3(int[] nums1, int m , int[] nums2, int n) {
        // 起始指针，从最后一个开始
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums2[p1--];
        }

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        return nums1;
    }
}
