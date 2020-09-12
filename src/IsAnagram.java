import java.util.Arrays;

/**
 * 有效的字母异位词
 * 242 https://leetcode-cn.com/problems/valid-anagram/
 */
public class IsAnagram {
    public static void main(String[] args) {

    }

    /**
     * 数组排序
     * 时间复杂度O(NlogN)
     * 空间复杂度O(N)
     * @param s
     * @param t
     * @return
     */
    public static boolean solution1(String s, String t) {
        // 边界条件
        if (s.length() != t.length()) return false;

        // 创建数组
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        // 数组排序
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }

    /**
     * 哈希表
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     * @param s
     * @param t
     * @return
     */
    public static boolean solution2(String s, String t) {
        // 边界条件
        if (s.length() != t.length()) return false;

        int[] counter = new int[26];

        // 统计计数
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        // 任何一个字母大于0，都不是异位词
        for (int count : counter) {
            if (count != 0) return false;
        }

        return true;
    }
}
