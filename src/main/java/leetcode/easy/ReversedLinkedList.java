package leetcode.easy;

/**
 * <p><a href="https://leetcode.com/problems/reverse-linked-list/">ReversedLinkedList</a></p>
 * <p>
 * ReversedLinkedList 문제는 링크드 리스트가 주어질 때,<br>
 * 해당 링크드 리스트를 역순으로 변환하는 문제입니다.<br>
 * </p>
 * <p>#linked-list, #recursion</p>
 */
public class ReversedLinkedList {
  /**
   * <p>Linked List</p>
   * <p>
   * 기준 노드, 다음 노드, 다다음 노드가 있다고 가정해봅시다.
   * (기준 노드는 처음에 헤드 노드임)
   * 1) 기준 노드를 다다음 노드로 이어줍니다.
   * 2) 다음 노드를 현재 헤드 노드로 이어줍니다.
   * 3) 기준 노드의 다음 노드가 null 일 때까지 이를 반복합니다.
   * 이 과정을 반복하면 헤드 노드는 꼬리 노드가 됩니다.
   * </p>
   */
  static class Solution {
    public ListNode reverseList(ListNode head) {
      return reverse(head);
    }

    private ListNode reverse(ListNode tailNode) {
      ListNode headNode = tailNode;
      while(tailNode != null && tailNode.next != null) {
        ListNode nextNode = tailNode.next;
        tailNode.next = nextNode.next;
        nextNode.next = headNode;
        headNode = nextNode;
      }
      return headNode;
    }
  }

  static public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
