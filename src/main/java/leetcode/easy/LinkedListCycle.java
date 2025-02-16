package leetcode.easy;

/**
 * <p><a href="https://leetcode.com/problems/linked-list-cycle/">LinkedListCycle</a></p>
 * <p>
 * LinkedListCycle 문제는 링크드 리스트가 주어질 때,<br>
 * 순환 가능한 링크드 리스트인지 판단하는 문제입니다.<br>
 * </p>
 * <p>#two-pointers, #hash-table</p>
 */
public class LinkedListCycle {
  /**
   * <p>DFS</p>
   * <p>
   * 링크드 리스트를 탐색하면서, 확인한 노드의 값을 변경해줍니다.
   * 변경된 노드의 값이 발견되면 순환 링크드 리스트임을 알 수 있습니다.
   * </p>
   */
  static class Solution {
    int checkValue = (int) Math.pow(10, 5) + 1;

    public boolean hasCycle(ListNode head) {
      if (head == null) return false;

      ListNode cur = head;
      while (cur.next != null && cur.next.val != checkValue) {
        cur.val = checkValue;
        cur = cur.next;
      }

      return cur.next != null;
    }
  }

  static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
      this.val = val;
      next = null;
    }
  }
}
