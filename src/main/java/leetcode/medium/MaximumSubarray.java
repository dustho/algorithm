package leetcode.medium;

/**
 *
 *
 *
 * maxSum은 지금까지의 최댓값을 저장한다.
 */
/**
 * <p><a href="https://leetcode.com/problems/maximum-subarray/">MaximumSubarray</a></p>
 * <p>
 * MaximumSubarray 문제는 부분 배열의 최대 합을 구하는 문제입니다.
 * </p>
 * <p>#kadane-algorithm</p>
 */
public class MaximumSubarray {
  /**
   * <p>Kadane Algorithm</p>
   * <p>
   * 배열을 왼쪽에서 오른쪽으로 순회하면서, 현재까지의 부분합 currentSum 을 계속 갱신합니다.
   * 단, currentSum 이 음수가 되면, 이를 버리고 새로운 부분 배열을 시작합니다.
   * currentSum 을 이용해 최대 부분합 max 를 갱신합니다.
   * </p>
   */
  static class Solution1 {
    public int maxSubArray(int[] nums) {
      int max = nums[0];
      int currentSum = 0;

      for (int num : nums) {
        if (currentSum < 0) {
          currentSum = 0;
        }

        currentSum += num;
        max = Math.max(max, currentSum);
      }

      return max;
    }
  }

  static class Solution2 {
    public int maxSubArray(int[] nums) {
      int max = nums[0];
      int sum = 0;

      for (int num : nums) {
        sum = Math.max(num, sum + num);
        max = Math.max(max, sum);
      }

      return max;
    }
  }
}