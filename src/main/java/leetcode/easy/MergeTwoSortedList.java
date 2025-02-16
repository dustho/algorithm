package leetcode.easy;

/**
 * <p><a href="https://leetcode.com/problems/first-bad-version/">FirstBadVersion</a></p>
 * <p>
 * MergeTwoSortedList 문제는 2개의 오름차순 정렬된 연결리스트가 주어질 떄, <br>
 * 하나의 오름차순 연결리스트로 병합하여 반환하는 문제입니다.<br>
 * </p>
 * <p>#linked-list, #recursion</p>
 */
public class MergeTwoSortedList {
  /**
   * <p>Linked List</p>
   * <p>
   * 2개의 연결리스트가 모두 null 이 될 때까지
   * 각 리스트의 숫자를 비교하면서 더 작은 리스트의 값을
   * 병합할 연결리스트에 next 로 생성해 붙여줍니다.
   * </p>
   */
  static class Solution {
    ListNode start = null;
    ListNode cur = null;

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      while (list1 != null || list2 != null) {
        if (list2 == null || list1 != null && list1.val < list2.val) {
          list1 = process(list1);
        } else if (list1 == null || list2 != null && list1.val >= list2.val) {
          list2 = process(list2);
        }
      }

      return start;
    }

    private ListNode process(ListNode list) {
      if (cur == null) {
        cur = new ListNode(list.val);
        start = cur;
      } else {
        cur.next = new ListNode(list.val);
        cur = cur.next;
      }
      return list.next;
    }
  }

  static class  ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}
