package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p><a href="https://leetcode.com/problems/3sum/">3Sum</a></p>
 * <p>
 * 3Sum 문제는 1차원 숫자 배열이 주어질 때,
 * 더해서 0이 나오는 3개의 원소를 리스트로 반환하는 문제입니다.
 * (동일한 원소 집합은 distinguish 합니다.)
 * </p>
 * <p>#array, #sort, #two-pointers</p>
 */
public class Sum3 {
  /**
   * <p>Sort And Two Pointers</p>
   * <p>
   * 배열을 오름차순 정렬한 뒤, 순회하면서 i 원소를 지정합니다.
   * i 보다 오른쪽에 있는 부분 배열을 대상으로 j 원소와 k 원소를 투포인터로 지정합니다.
   * i, j, k 위치의 원소를 더해 0인지 구별합니다.
   * - 0 이라면, j를 동일한 원소가 아닐 때까지 오른쪽으로 이동합니다.
   * - 0 보다 작다면, j를 오른쪽으로 1칸 이동합니다.
   * - 0 보다 크다면, k를 왼쪽으로 1칸 이동합니다.
   * </p>
   */
  static class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);

      List<List<Integer>> result = new ArrayList<>();

      for(int i = 0; i < nums.length; i++) {
        if (i > 0 && nums[i] == nums[i-1]) continue;

        int j = i + 1;
        int k = nums.length - 1;

        while (j < k) {
          int sum = nums[i] + nums[j] + nums[k];
          if (sum == 0) {
            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
            j++;
            while (j < k && nums[j] == nums[j-1]) {
              j++;
            }
          } else if (sum > 0) {
            k--;
          } else {
            j++;
          }
        }
      }

      return result;
    }
  }
}
