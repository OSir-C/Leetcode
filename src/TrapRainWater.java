/**
 * 42. 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class TrapRainWater {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution1(height));
    }

    /**
     * 简单遍历求解
     * 木桶效应
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 基本原理：看每一列的头顶能顶多少水，顶水的多少取决于该木板两侧最高的两块木板中较矮的那个
     * @return
     */
    public static int solution1(int[] height) {
        int sum = 0;
        
        // 遍历每一列，除了第一列和最后一列，因为没有墙能帮它挡水
        for (int i  = 1; i < height.length - 1; i++) {
            // 找出该木板左侧最高的
            int max_left = 0;
            for (int j = 0; j < i; j++) {
                max_left = Math.max(max_left, height[j]);
            }
            
            // 找出该木板右侧最高的
            int max_right = 0;
            for (int j = height.length - 1; j > i; j--) {
                max_right = Math.max(max_right, height[j]);
            }
            
            // 找出两者中较小的那一个
            int min = Math.min(max_left, max_right);

            // 计算头顶多少水,公式： water = min - height
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }

    /**
     * 动态规划
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     * @return
     */
    public static int solution2(int[] height) {
        int sum = 0;
        int len = height.length;

        // 针对上边的方法发现，每一列都要求解一遍所有列的高度，没有必要
        // 使用数组缓存下来每一列的最左高度和最右高度
        // 某一列i的左边的最高高度其实就是 之前一列i-1的左边的最高高度与i-1列高度中的较大的值
        // 某一列i的右边的最高高度其实就是 之后一列i+1的右边的最高高度与i+1列高度中的较大值
        int[] max_left = new int[len];
        int[] max_right = new int[len];
        for (int i = 1; i < len - 1; i++) {
            max_left[i] = Math.max(max_left[i-1], height[i-1]);
        }

        for (int j = len - 2; j >= 0; j--) {
            max_right[j] = Math.max(max_right[j+1], height[j+1]);
        }

        // 计算每一列的和
        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }

        return sum;
    }

    /**
     * 优化的动态规划(空间复杂度)
     * @return
     */
    public static int solution3(int[] height) {
        int sum = 0;
        int len = height.length;

        int max_left = 0;
        int[] max_right = new int[len];

        for (int i = len - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i+1], height[i+1]);
        }

        for (int i = 1; i < len - 1; i++) {
            max_left = Math.max(max_left, height[i - 1]);
            int min = Math.min(max_left, max_right[i]);

            if (min > height[i]) {
                sum += min - height[i];
            }
        }

        return sum;
    }

    /**
     * 双指针
     * @TODO 待完成
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @return
     */
    public static int solution4(int[] height) {
        int sum = 0;
        int len = height.length;
        int max_left = 0;
        int max_right = 0;

        // 声明两个指针
        int left = 1;
        int right = len - 2;

        for (int i = 1; i < height.length - 1; i++) {
            // 从左向右移动指针
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum += min - height[left];
                }
                left++;
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum += min - height[right];
                }
                right--;
            }
        }

        return sum;
    }

    /**
     * 栈
     * @TODO 待完成
     * @param height
     * @return
     */
    public static int solution5(int[] height) {
        int sum = 0;
        int len = height.length;

        return sum;
    }

    /**
     * 按行求解
     * 超出时间限制，原因：与level高度有关，O(M * N)
     * @return
     */
    public static int solution6(int[] height) {
        // 总积水
        int sum = 0;

        // 获取总层级
        int levels = 0;
        for (int i = 0; i < height.length; i++) {
            levels = Math.max(levels, height[i]);
        }

        // 开始遍历每一层
        for (int i = 1; i <= levels; i++) {
            // 指定临时变量，保存某一段的积水
            int temp = 0;
            // 标志位，表示是否启动存水（第一次可能存水的标志）
            boolean flag = false;
            for (int j = 0; j < height.length; j++) {
                // 如果当前位置高度小于当前层级高度，说明可能可以纯水（除了第一个位置）
                if (flag == true && height[j] < i) {
                    temp++;
                }

                // 如果遇到当前位置高度大于等于当前层级高度，说明之前的堤坝可以封上存水了
                if (height[j] >= i) {
                    sum += temp;
                    temp = 0; // 重新初始化，等待下一个堤坝
                    flag = true; // 启动存水
                }
            }
        }

        return sum;
    }
}
