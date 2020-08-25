/**
 * 11 盛水最多的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class MaxArea {
    public static void main(String[] args) {

    }

    /**
     * 双指针法
     * 面积计算公式： area = min(ha, hb) * (b - a)
     * a,b指针初始在头尾两端
     * 由公式可以知道，面积等于两者中高度较小者来决定
     * 因此要靠里移动较小的指针
     * @param height
     * @return
     */
    public static int solution(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;

        while(i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);

            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    /**
     * 精简写法
     * @param height
     * @return
     */
    public static int solution2(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;

        while(i < j) {
            maxArea = height[i] > height[j] ?
                    Math.max(maxArea, (j - i) * height[j--]) :
                    Math.max(maxArea, (j - i) * height[i++]);
        }
        return maxArea;
    }
}
