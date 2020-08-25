import java.util.HashSet;
import java.util.Set;

/**
 * 141.环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class CycleLinkedList {
    public static void main(String[] args) {

    }

    /**
     * 快慢指针
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * 忘记边界条件
     * while循环条件理解错误
     *
     * @param head
     * @return
     */
    public static boolean solution1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) { // 只要fast 和 slow不相遇就一直运行
            if (fast == null || fast.next == null) { //当 fast 和slow 其中一个为null，肯定不是环
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    /**
     * 哈希表
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * @param head
     * @return
     */
    public static boolean solution2(ListNode head) {
        Set<ListNode> hasList = new HashSet<>();

        while (head != null) {
            if (!hasList.contains(head)) {
                hasList.add(head);
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }
}
