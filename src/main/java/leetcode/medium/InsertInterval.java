package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <p><a href="https://leetcode.com/problems/insert-interval/">InsertInterval</a></p>
 * <p>
 * InsertInterval 문제는 겹치지 않는 범위들의 배열과 또 다른 특정 범위가 주어질 때,
 * 특정 범위를 합친 배열을 반환하는 문제입니다.
 * </p>
 * <p>#array</p>
 */
public class InsertInterval {
  /**
   * <p>Array</p>
   * <p>
   * 범위 배열을 순회하면 다음과 같이 조건을 나눌 수 있습니다.
   * - 범위가 겹치지 않는 상황
   *   - newInterval 이 왼쪽: newInterval 을 리스트에 할당합니다.
   *   - newInterval 이 오른쪽: interval 을 리스트에 할당합니다.
   * - 범위가 겹치는 상황: 시작점 중 작은 값을 newInterval 의 시작, 끝 점 중 큰 값을 newInterval 의 끝으로 할당합니다.
   * </p>
   */
  static class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      List<int[]> result = new ArrayList<>();

      for (int[] interval : intervals) {
        if (newInterval[1] < interval[0]) { // 범위가 겹치지 않는 상황 (newInterval 이 왼쪽)
          result.add(newInterval);
          newInterval = interval;
        } else if (newInterval[0] > interval[1]) { // 범위가 겹치지 않는 상황 (newInterval 이 오른쪽)
          result.add(interval);
        } else { // 범위가 겹치는 상황
          newInterval[0] = Math.min(newInterval[0], interval[0]);
          newInterval[1] = Math.max(newInterval[1], interval[1]);
        }
      }
      result.add(newInterval);

      return result.toArray(new int[0][0]);
    }
  }

}
