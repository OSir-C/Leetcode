import java.util.Arrays;

/**
 * 88.合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {
    public static void main(String[] args) {

    }

    /**
     * 系统排序
     * 时间复杂度 O( (m+n)Log(m+n) )
     * 空降复杂度 O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void solution1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 从前往后
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void solution2(int[] nums1, int m, int[] nums2, int n) {
        // 创建nums1的副本
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        int p1 = 0, p2 = 0, p1_copy = 0;
        while (p1_copy < m && p2 < n) {
            nums1[p1++] = nums1_copy[p1_copy] < nums2[p2] ? nums1_copy[p1_copy++] : nums2[p2++];
        }

        // 处理剩余未参加比较的元素
        if (p1_copy < m) System.arraycopy(nums1_copy, p1_copy, nums1, p1_copy + p2, m - p1_copy);
        if (p2 < n) System.arraycopy(nums2, p2, nums1, p1_copy + p2, n - p2);
    }

    /**
     * 从后往前
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void solution3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p  = nums1.length - 1;

        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }

        // 如果p1提前走完，复制剩余num2元素到nums1
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
