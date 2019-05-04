package com.handsomewu.hellospring;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionListNode {

    //链表反转
    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode e = null, f = null, cur = head;
        while ((e = cur.next) != null) {
            cur.next = f;
            f = cur;
            cur = e;
        }
        cur.next = f;
        return cur;
    }

    //合并有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;

        }
        return head.next;
    }

    //两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode cur = head;
        int more = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + more;
            more = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (more > 0) {
            cur.next = new ListNode(more);
        }

        return head.next;
    }

    //链表是否有环
    public boolean hasCycle1(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode e = head;
        while (e != null) {
            if (set.contains(e)) {
                return true;
            } else {
                set.add(e);
                e = e.next;
            }
        }
        return false;
    }

    //链表是否有环  快慢指针
    public boolean hasCycle2(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next,fast = head.next.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    //链表的中间节点  先计算出中间点 再遍历
    public ListNode middleNode1(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode e = head;
        int count = 0;
        while (e != null) {
            count++;
            e = e.next;
        }
        int middle = count / 2 + 1;
        e = head;
        int i = 1;
        while (e != null && i < middle) {
            e = e.next;
            i++;
        }
        return e;
    }

    //链表的中间节点   数组存放
    public ListNode middleNode2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode[] listNodes = new ListNode[100];
        ListNode e = head;
        int i = 0;
        while (e != null) {
            listNodes[i++] = e;
            e = e.next;
        }
        return listNodes[i / 2];
    }

    //链表的中间节点  快慢指针
    public ListNode middleNode3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    //删除链表的倒数第N个节点   即删除正数第count-n+1个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //计算总长度
        ListNode e = head;
        int count = 0;
        while (e != null) {
            count++;
            e = e.next;
        }

        //找出第count-N个节点，将其next指向next.next
        e = dummy;
        int i = 0;
        while (e != null) {
            if (i == count - n) {
                e.next = e.next.next;
                break;
            }
            i++;
            e = e.next;
        }
        return dummy.next;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
