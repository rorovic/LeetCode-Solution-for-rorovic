package main.java.solution;

/**
 * Created by dujinyuan on 17/5/8.
 * EN:
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
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

public class AddTwoNum2 {

    public static LinkedList addTwoNumbers(LinkedList link1,LinkedList link2){
        int maxLength;
        int minLength;
        LinkedList resultLink;//结果链表
        int carry;
        if(link1.size()>link2.size()){
            resultLink = link1;
            maxLength = link1.size();
            minLength = link2.size();
        } else {
            resultLink = link2;
            maxLength = link2.size();
            minLength = link1.size();
        }
        for(int i =0;i<minLength;i++){
            carry = 0;
            int result = (int)link1.get(i)+(int)link2.get(i)+carry;
            if(result>=10){//进位
                carry = result/10;
                if(i==minLength-1){//超出了链表长度
                    if(i<maxLength-1){//没有超出最长，不用加位置
                        resultLink.set(i+1, (int)resultLink.get(i+1)+carry);
                    }else {//超出最长需要加链表长度
                        resultLink.addLast(carry);
                    }
                }
                resultLink.set(i, result%10);
            }else {//不进位
                resultLink.set(i, result);
            }
        }
        return resultLink;
    }

    public static void main(String[] args){
        //1 > 2
        LinkedList link1 = new LinkedList();
        link1.addLast(1);
        link1.addLast(2);
        //1 > 9 > 2
        LinkedList link2 = new LinkedList();
        link2.addLast(1);
        link2.addLast(9);
        link2.addLast(2);
        LinkedList resultLink = addTwoNumbers(link1, link2);
        //21+291 = 312 > 2 1 3
        for(Object i : resultLink){
            System.out.println(""+(int)i);
        }

    }
}
