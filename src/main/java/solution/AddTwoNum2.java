package main.java.solution;

/**
 * Created by dujinyuan on 17/5/8.
 * EN:
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)      342   +    465     =   807   =   7 0 8
 * Output: 7 -> 0 -> 8
 * CH:
 *  有两个链表作为输入，它们表示逆序的两个非负数。如下面的两个链表表示的是342和465这两个数。
 *  你需要计算它们的和并且用同样的方式逆序输出。如342+465 = 807,你需要把结果表达为7 ->0 ->8
 */


import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
}

public class AddTwoNum2 {

    /**
     * Two things to make the code simple:
     Whenever one of the two ListNode is null, replace it with 0.
     Keep the while loop going when at least one of the three conditions is met.
     *
     * @param l1
     * @param l2
     * @return
     */
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }

    /**
     * Java solution -- concise and easy to understand
     * @param l1
     * @param l2
     * @return
     */
    static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;

        ListNode head = new ListNode(0);
        ListNode p = head;

        int tmp = 0;
        while(l1!=null || l2!=null || tmp!=0) {
            if(l1!=null) {
                tmp += l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                tmp += l2.val;
                l2 = l2.next;
            }

            p.next = new ListNode(tmp%10);
            p = p.next;
            tmp = tmp/10;
        }
        return head.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(3);
        l1.next.val = 1;
        l1.next.val = 2;
        ListNode l2 = new ListNode(3);
        l2.next.val = 10;
        l2.next.val = 8;
        l2.next.val = 9;
        addTwoNumbers(l1,l2);



    }
}
