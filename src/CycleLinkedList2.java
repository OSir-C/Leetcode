import java.util.HashSet;
import java.util.List;
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
     * 快慢指针
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     * @param head
     * @return
     */
    public ListNode solution2(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null; // 非有环链表

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) break; // 在环内相遇
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
