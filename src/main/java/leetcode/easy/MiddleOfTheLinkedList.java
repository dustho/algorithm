package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <p><a href="https://leetcode.com/problems/middle-of-the-linked-list/">MiddleOfTheLinkedList</a></p>
 * <p>
 * MiddleOfTheLinkedList 문제는 링크드 리스트의 중간 노드를 반환하는 문제입니다.
 * </p>
 * <p>#linked-list, #two-pointers</p>
 */
public class MiddleOfTheLinkedList {
  /**
   * <p>Loop</p>
   * <p>
   * 링크드 리스트를 순회하면서 각 노드를 리스트에 저장합니다.
   * 인덱스가 (리스트 길이 / 2) 인 노드를 반환합니다.
   * </p>
   */
  static class Solution {
    List<ListNode> list = new ArrayList<>();

    public ListNode middleNode(ListNode head) {
      ListNode cur = head;
      while(cur != null) {
        list.add(cur);
        cur = cur.next;
      }
      return list.get(list.size() / 2);
    }
  }

  /**
   * <p>Two Pointers</p>
   * <p>
   * 하나의 포인터는 1칸씩, 하나의 포인터는 2칸씩 이동합니다.
   * 2칸씩 이동하는 포인터가 더이상 움직일 수 없을 때, 1칸씩 이동하는 포인터를 반환합니다.
   * </p>
   */
  static class Solution2 {
    public ListNode middleNode(ListNode head) {
      ListNode oneStepNode = head;
      ListNode twoStepNode = head;
      while(twoStepNode != null && twoStepNode.next != null) {
        oneStepNode = oneStepNode.next;
        twoStepNode = twoStepNode.next.next;
      }
      return oneStepNode;
    }
  }

  static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
