package leetcode.easy;

import java.util.Arrays;

/**
 * <p><a href="https://leetcode.com/problems/missing-number/">MissingNumber</a></p>
 * <p>
 * MissingNumber 문제는 0 부터 n 까지의 숫자 중에 배열에서 빠진 숫자를 구하는 문제입니다.
 * </p>
 * <p>#binary-search, #hash-table</p>
 */
public class MissingNumber {
  /**
   * <p>Sum</p>
   * <p>
   * [0, n] 배열의 합 - 주어진 배열의 합을 반환합니다.
   * </p>
   */
  static class Solution1 {
    public int missingNumber(int[] nums) {
      int sum = 0;
      int sumOfArr = 0;

      for (int i = 0; i < nums.length; i++) {
        sum += i;
        sumOfArr += nums[i];
      }
      sum += nums.length;

      return sum - sumOfArr;
    }
  }

  /**
   * <p>Binary Sorting</p>
   * <p>
   * 정렬한 배열을 순회하면서 빠진 숫자를 찾습니다.
   * </p>
   */
  static class Solution2 {
    public int missingNumber(int[] nums) {
      Arrays.sort(nums);

      int idx = 0;
      while(idx < nums.length) {
        if (nums[idx] != idx) {
          return idx;
        }
        idx++;
      }

      return idx;
    }

  }
}
