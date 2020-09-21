import java.util.*;

/**
 * 49.字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagram {
    public static void main(String[] args) {

    }

    /**
     * 排序分组
     * 时间复杂度 O(NKlogK)
     * 空间复杂度 O(NK)
     * @param strs
     * @return
     */
    public static List<List<String>> solution1(String[] strs) {
        if (strs.length == 0) return new ArrayList();

        Map<String, List> ans = new HashMap<>();
        // 遍历各个字符串元素
        for (String s : strs) {
            char[] ca = s.toCharArray(); // 拆分成单个字母
            Arrays.sort(ca);
            String key = String.valueOf(ca); // 合并数组元素获得key
            if (!ans.containsKey(key)) ans.put(key, new ArrayList()); // 如果key不存在，加入一个key
            ans.get(key).add(s); // 给key赋值
        }

        return new ArrayList(ans.values());
    }

    /**
     * 计数分类
     * 时间复杂度O(N*K)
     * 空间复杂度O(N*K)
     * @param strs
     * @return
     */
    public static List<List<String>> solution2(String[] strs) {
        if (strs.length == 0) return new ArrayList();

        Map<String, List> ans = new HashMap<>();
        int[] count = new int[26];

        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char ca : s.toCharArray()) count[ca - 'a']++;

            StringBuilder sb = new StringBuilder("");
            // bbaabb形如 #2#4
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }

            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList()); // 如果key不存在，加入一个key
            ans.get(key).add(s); // 给key赋值
        }
        return new ArrayList(ans.values());
    }
}
