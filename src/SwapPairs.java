import java.util.stream.LongStream;

/**
 * 24.两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapPairs {
    public static void main(String[] args) {

    }

    /**
     * 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     * @param head
     * @return
     */
    public static ListNode iteratively(ListNode head) {
        ListNode dummy = new ListNode(-1); // 声明一个虚拟指针，next始终指向head
        dummy.next = head;

        ListNode prevNode = dummy;
        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // 交换
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            prevNode.next = secondNode;

            // 移动指针
            prevNode = firstNode;
            head = firstNode.next;
        }

        return dummy.next;
    }

    /**
     * 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * @param head
     * @return
     */
    public static ListNode recursively(ListNode head) {
        // 递归终止条件
        if (head == null || head.next == null) return head;

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // 交换本层的两个结点
        firstNode.next = recursively(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }
}
