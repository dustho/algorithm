package leetcode.medium;

import java.util.Arrays;

/**
 * <p><a href="https://leetcode.com/problems/sum-of-two-integers/">HouseRobber</a></p>
 * <p>
 * HouseRobber 문제는 인접한 집은 도둑질하지 못하는 상황에서
 * 최대한 많은 돈을 도둑질했을 때의 값을 반환하는 문제입니다.
 * </p>
 * <p>#array, #dynamic-programming</p>
 */
public class HouseRobber {
  /**
   * <p>DP</p>
   * <p>
   * 1칸 이동할 때는 도둑질을 하지 않고, 2칸 이동할 때는 도둑질을 합니다.
   * 최대 값을 Memoization 을 이용해 저장하여 시간을 단축시킵니다.
   * </p>
   */
  static class Solution {
    int[] memo;

    public int rob(int[] nums) {
      if (nums.length == 1) {
        return nums[0];
      }

      memo = new int[nums.length];
      Arrays.fill(memo, -1);
      return getMoney(nums, 0);
    }

    private int getMoney(int[] nums, int cur) {
      if (nums.length <= cur) {
        return 0;
      } else if (memo[cur] >= 0) {
        return memo[cur];
      }

      memo[cur] = Math.max(getMoney(nums, cur+1), nums[cur] + getMoney(nums, cur+2));
      return memo[cur];
    }
  }
}
