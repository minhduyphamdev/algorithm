import java.util.*;

public class DailyTemperatures {
  public int[] dailyTemperatures(int[] tempatures) {
    int[] results = new int[tempatures.length];
    Stack<Integer> stack = new Stack<>();

    for(int i=0;i<tempatures.length;i++) {
      while(!stack.isEmpty() && tempatures[stack.peek()] < tempatures[i]) {
        results[stack.peek()] = i - stack.pop();
      }

      stack.push(i);
    }

    return results;
  }

  public static void main(String[] args) {
    DailyTemperatures dt = new DailyTemperatures();
    // int[] tempatures = {73, 74, 75, 71, 69, 72, 76, 73};
    int[] tempatures = {79,71};
    int[] sol = dt.dailyTemperatures(tempatures);
    for(int i : sol) {
      System.out.println(i);
    }
  }
}
 