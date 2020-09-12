/**
 * 641. 设计循环双端队列
 * https://leetcode-cn.com/problems/design-circular-deque/
 * 说明：
 * 需要两个指针 front  rear
 * front == rear 队列为空
 * rear.next = front
 */
public class MyCircularDeque {
    private int capacity; // 容量
    private int[] arr;
    private int front; // 指向队列第一个有效位置
    private int rear; // 指向队列尾部的下一个位置，也就是下一个要从尾部进入队列的位置
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        capacity = k + 1;
        arr = new int[capacity];
        front = 0;
        rear = 0;
    }
}
