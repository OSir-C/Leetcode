/**
 * 206.反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLikedList {
    public static void main(String[] args) {

    }

    public ListNode solution(ListNode head) {
        ListNode ans = new ListNode();

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode tmpNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmpNode;
        }

        return ans;
    }
}