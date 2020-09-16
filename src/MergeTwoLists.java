/**
 * 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {
    public static void main(String[] args) {

    }

    /**
     * 递归法
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode solution1(ListNode l1, ListNode l2) {
        if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else if (l1.val < l2.val) {
            l1.next = solution1(l1.next, l2);
            return l1;
        }  else {
            l2.next = solution1(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代法
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode solution2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode prev = head;

        while (l1.next != null && l2.next != null) {
            if (l1.val < l2.val) {
                prev.next = l1; // 第一次的操作因为prev和head是同一个node，所以相当于把head.next指向了新链表的头，下同
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }

        /**
         * 以上最后一次循环，移动完prev之后
         * 处理prev.next,要么是l2要么是l1
         */
        prev.next = l1 == null ? l2 : l1;

        return head.next;
    }
}
