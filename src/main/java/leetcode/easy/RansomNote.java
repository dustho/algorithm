package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <p><a href="https://leetcode.com/problems/ransom-note/">RansomNote</a></p>
 * <p>
 * RansomNote 문제는 ransomNote, magazine 두 문자열이 주어질 때, <br>
 * magazine 의 문자들을 이용해 ransomNote 를 만들 수 있는지 확인하는 문제입니다.<br>
 * </p>
 * <p>#hash-table</p>
 */
public class RansomNote {
  /**
   * <p>Hash Table</p>
   * <p>
   * magazine 과 ransomNote 를 동시에 순회하면서,
   * magazine 의 문자에 대해서는 +1 씩 map 에 반영하고
   * ransomNote 의 문자에 대해서는 -1 씩 map 에 반영합니다.
   * map 의 value 를 순회하면서 음수가 나오면 false, 아니면 true 를 반환합니다.
   * </p>
   */
  static class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
      Map<Character, Integer> map = new HashMap<>();
      char[] mags = magazine.toCharArray();
      char[] rans = ransomNote.toCharArray();

      if (mags.length < rans.length) {
        return false;
      }

      for (int i = 0; i < mags.length; i++) {
        map.put(mags[i], map.getOrDefault(mags[i], 0) + 1);
        if (i < rans.length) {
          map.put(rans[i], map.getOrDefault(rans[i], 0) - 1);
        }
      }

      for (int val: map.values()) {
        if (val < 0) {
          return false;
        }
      }

      return true;
    }
  }
}
