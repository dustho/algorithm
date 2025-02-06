package leetcode.easy;


import java.util.Stack;

/**
 * <p><a href="https://leetcode.com/problems/add-binary/">AddBinary</a></p>
 * <p>
 * AddBinary 문제는 이진수 문자열 2개가 주어질 때,<br>
 * 두 이진수의 합을 문자열로 반환하는 문제입니다.<br>
 * </p>
 * <p>#bit-manipulation</p>
 */
public class AddBinary {
  /**
   * <p>Stack / Bit Manipulation</p>
   * <p>
   * 먼저 길이가 작은 이진수 문자열에 대해서 0을 채워줍니다.
   * 문자열을 동일한 인덱스로 순회하면서 더하기 하여, 각 자리수의 결과를 stack 에 push 해줍니다.
   * 마지막에 carry 가 존재하면 stack 에 1을 추가해줍니다.
   * stack 에 쌓인 순서와 반대로 출력해줍니다.
   * </p>
   */
  static class Solution {
    public String addBinary(String a, String b) {
      if (a.length() > b.length()) {
        b = addZero(b, a.length() - b.length());
      } else {
        a = addZero(a, b.length() - a.length());
      }

      Stack<Integer> stack = new Stack<>();
      int sum = 0;
      int tmp = 0;
      int carry = 0;
      for (int i = a.length() - 1; i >= 0; i--) {
        int num1 = Character.getNumericValue(a.charAt(i));
        int num2 = Character.getNumericValue(b.charAt(i));

        if (carry == 0) {
          sum = num1 ^ num2;
          carry = num1 & num2;
        } else {
          tmp = num1 ^ num2;
          sum = carry ^ tmp;
          carry = Math.max(num1 & num2, tmp & carry);
        }
        stack.push(sum);
      }

      if(carry == 1) {
        stack.push(carry);
      }

      StringBuilder sb = new StringBuilder();
      while (!stack.isEmpty()) {
        sb.append(stack.pop());
      }

      return sb.toString();
    }

    private String addZero(String str, int len) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < len; i++) {
        sb.append("0");
      }
      sb.append(str);
      return sb.toString();
    }
  }
}
