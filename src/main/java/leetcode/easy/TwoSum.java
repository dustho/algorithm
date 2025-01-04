package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <p><a href="https://leetcode.com/problems/two-sum/">TwoSum</a></p>
 * <p>
 * TwoSum 문제는 nums 라는 숫자 배열이 주어질 때,<br>
 * 배열의 원소 2개의 합이 target 값이 되는 경우를 찾고<br>
 * 해당 원소들의 인덱스를 반환하는 문제입니다.<br>
 * </p>
 * <p>#array, #hash-table</p>
 */
public class TwoSum {

  /**
   * <p>Brute Force</p>
   * <p>
   * 2중 for 문을 활용한 풀이로 가장 기본적인 풀이 방식입니다.
   * </p>
   */
  public int[] twoSum1(int[] nums, int target) {
    for (int p1 = 0; p1 < nums.length; p1++) {
      for (int p2 = p1 + 1; p2 < nums.length; p2++) {
        int sum = nums[p1] + nums[p2];
        if (sum == target) {
          return new int[]{p1, p2};
        }
      }
    }
    return new int[]{-1, -1};
  }

  /**
   * <p>HashMap two pass</p>
   * <p>
   * 원소와 target 의 차를 Key, 빼기에 사용한 원소의 인덱스 정보를 Value 로 저장합니다.<br>
   * Key 정보와 일치하는 원소가 있으면, 해당 원소와 key 의 합은 target 이 됩니다.
   * </p>
   */
  public int[] twoSum2(int[] nums, int target) {
    Map<Integer, Integer> diffIdxMap = new HashMap<>();
    for (int p1 = 0; p1 < nums.length; p1++) {
      diffIdxMap.put(target - nums[p1], p1);
    }

    for (int p1 = 0; p1 < nums.length; p1++) {
      if (diffIdxMap.containsKey(nums[p1]) && p1 != diffIdxMap.get(nums[p1])) {
        return new int[]{p1, diffIdxMap.get(nums[p1])};
      }
    }

    return new int[]{-1, -1};
  }

  /**
   * <p>HashMap one pass</p>
   * <p>
   * HashMap two pass 와 기본적인 풀이 방식은 비슷합니다.<br>
   * 중복되는 원소를 건너뛰어 1번의 루프로 문제를 해결할 수 있습니다.
   * </p>
   */
  public int[] twoSum3(int[] nums, int target) {
    Map<Integer, Integer> diffIdxMap = new HashMap<>();
    for (int p1 = 0; p1 < nums.length; p1++) {
      if (diffIdxMap.containsKey(nums[p1]) && p1 != diffIdxMap.get(nums[p1])) {
        return new int[]{p1, diffIdxMap.get(nums[p1])};
      }
      diffIdxMap.put(target - nums[p1], p1);
    }

    return new int[]{-1, -1};
  }

}
