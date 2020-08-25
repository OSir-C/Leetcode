import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class CycleLinkedList2 {
    public static void main(String[] args) {

    }

    /**
     * 哈希表
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param head
     * @return
     */
    public static ListNode solution1(ListNode head) {
        Set<ListNode> list = new HashSet<>();
        while (head != null) {
            if (list.contains(head)) {
                return head;
            } else {
                list.add(head);
                head = head.next;
            }
        }

        return null;
    }

    /**
     * solution2的第一步：判断是否有环，并返回相遇的节点
     * @return
     */
    public static ListNode getIntersect(ListNode head) {
        return null;
    }

    /**
     *  迭代法
     *  时间复杂度O(N)
     *  空间复杂度O(1)
     * @param head
     * @return
     */
    public ListNode solution2(ListNode head) {
        return null;
    }
}
