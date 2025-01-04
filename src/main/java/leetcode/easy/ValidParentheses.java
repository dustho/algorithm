package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <p><a href="https://leetcode.com/problems/valid-parentheses/">ValidParentheses</a></p>
 * <p>
 * (){}[] 문자로 구성된 문자열이 주어줄 때, 괄호 짝이 맞는지를 판단하는 문제입니다.<br>
 * </p>
 * <p>#string, #stack</p>
 */
public class ValidParentheses {

  /**
   * <p>Stack</p>
   * <p>
   * 괄호 짝 문제는 전형적인 Stack 유형의 문제입니다.
   * 여는 괄호는 push, 닫는 괄호는 올바른 짝이면 pop 을 해줍니다.
   * 만약 올바른 짝이 아닐 경우 false 를 반환합니다.
   * 마지막에는 stack 이 비어있어야 합니다. (여는 괄호가 남아있는 상황 방지)
   * </p>
   */
  static class Solution {
    public boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();

      for (char c: s.toCharArray()) {
        if (c == '[' || c == '{' || c == '(') {
          stack.push(c);
        } else if (!stack.isEmpty() && isPair(stack.peek(), c)) {
          stack.pop();
        } else {
          return false;
        }
      }

      return stack.isEmpty();
    }

    private boolean isPair(char open, char close) {
      return (open == '(' && close == ')')
          || (open == '{' && close == '}')
          || (open == '[' && close == ']');
    }
  }

}
