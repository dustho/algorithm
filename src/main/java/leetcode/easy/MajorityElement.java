package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <p><a href="https://leetcode.com/problems/majority-element/">MajorityElement</a></p>
 * <p>
 * MajorityElement 문제는 숫자 배열이 주어질 때,<br>
 * 개수가 배열의 개수 / 2 보다 더 큰 숫자를 찾아내는 문제입니다.<br>
 * </p>
 * <p>#hash-table, #divide-and-conquer, #sorting</p>
 */
public class MajorityElement {
  /**
   * <p>Hash Table</p>
   * <p>
   * 배열 내 숫자들의 개수를 Map 에 저장합니다.
   * Map 에서 배열의 개수 / 2 보다 큰 숫자를 반환합니다.
   * </p>
   */
  static class Solution {
    public int majorityElement(int[] nums) {
      int halfLen = nums.length / 2;
      Map<Integer, Integer> map = new HashMap<>();
      for (int num: nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
        if (map.get(num) > halfLen) {
          return num;
        }
      }
      return 0;
    }
  }
}
