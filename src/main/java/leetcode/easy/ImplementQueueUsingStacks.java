package leetcode.easy;

import java.util.Stack;

/**
 * <p><a href="https://leetcode.com/problems/implement-queue-using-stacks/">ImplementQueueUsingStacks</a></p>
 * <p>
 * ImplementQueueUsingStacks 문제는 Stack 2개를 활용해 Queue 메서드를 구현하는 문제입니다.
 * </p>
 * <p>#stack, #queue</p>
 */
public class ImplementQueueUsingStacks {
  /**
   * <p>Stack</p>
   * <p>
   * push 메서드가 호출될 때마다 queue 라는 이름의 스택에
   * 숫자를 반대로 저장해주면 Queue 와 동일하게 사용할 수 있습니다.
   * </p>
   */
  static class MyQueue {
    Stack<Integer> tmp = new Stack();
    Stack<Integer> queue = new Stack();

    public MyQueue() {
    }

    public void push(int x) {
      while (!queue.isEmpty()) {
        tmp.push(queue.pop());
      }
      queue.push(x);
      while (!tmp.isEmpty()) {
        queue.push(tmp.pop());
      }
    }

    public int pop() {
      return queue.pop();
    }

    public int peek() {
      return queue.peek();
    }

    public boolean empty() {
      return queue.isEmpty();
    }
  }
}
