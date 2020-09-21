/**
 * 25. K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseKGroup {
    public static void main(String[] args) {

    }

    /**
     *
     * 时间复杂度 O(N * K)
     * 空间复杂度 O(1)
     * @param head
     * @param k
     * @return
     */
    public static ListNode iteratively(ListNode head, int k) {
        // 极端情况下，直接返回原链表
        if (head == null || head.next == null || k <= 1) return head;

        // 虚拟节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        while (prev != null) {
            // 本组的开始节点
            ListNode start = prev.next;
            ListNode end = prev.next;

            // 定位本组结束的节点
            for (int i = 0; i < k - 1 && end != null; i++) end = end.next;
            if (end == null) break; // 不足一组，不用反转，直接返回结果了

            ListNode follow = end.next; // 本组最后一个节点的后续节点存下来
            end.next = null;// 切断当前组和后边组的联系
            prev.next = reverse(start); // 反转当前组，前驱节点指向反转之后的新的头节点

            // 反转完成，移动指针到下一组
            start.next = follow;
            prev = start;
        }

        return dummy.next;
    }

    /**
     * 小组内的反转
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        ListNode prev = new ListNode(-1);
        ListNode curr = head;

        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}
