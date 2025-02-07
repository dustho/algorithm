package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * <p><a href="https://leetcode.com/problems/add-binary/">ContainsDuplicate</a></p>
 * <p>
 * ContainsDuplicate 문제는 숫자 배열에 중복되는 문자열이 있는지<br>
 * 확인하여, 참 혹은 거짓을 반환하는 문제입니다.<br>
 * </p>
 * <p>#array, #hash-table, #sorting</p>
 */
public class ContainsDuplicate {
  /**
   * <p>Hash Set</p>
   * <p>
   * 숫자 배열을 순회하면서 Set 에 해당 값이 있는지 체크합니다.
   * 없다면 Set 에 해당 값을 추가합니다.
   * 있다면 Set 에 true 를 반환합니다.
   * 마지막까지 도달하면 false 를 반환합니다.
   * </p>
   */
  static class Solution {
    public boolean containsDuplicate(int[] nums) {
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < nums.length; i++) {
        if (set.contains(nums[i])) {
          return true;
        } else {
          set.add(nums[i]);
        }
      }
      return false;
    }
  }
}
