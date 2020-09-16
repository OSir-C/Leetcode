/**
 * 206.反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLikedList {
    public static void main(String[] args) {

    }

    /**
     * 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     * @param head
     * @return
     */
    public ListNode solution(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * @param head
     * @return
     */
    public ListNode solution2(ListNode head) {
        // 递归终止条件
        if (head == null || head.next == null) return head;

        // 下探
        ListNode ans = solution2(head.next);

        // 处理当前层逻辑
        head.next.next = head;
        head.next = null;

        return ans;
    }
}