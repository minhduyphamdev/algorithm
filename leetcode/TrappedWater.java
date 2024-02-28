import java.util.*;

public class TrappedWater {
  // so nuoc co the chua tinh dua tren min( maxleft, ,maxright ) cua 2 ben, so nuoc chua duoc se xu duoc tinh huong ve smallest height

  public int trap(int[] height) {
      Stack<Integer> stack = new Stack<Integer>();
      int water = 0;
      for(int i=0;i<height.length;i++) {
        // so luong nuoc co the chua toi da tai vi tri top 
        while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
          int top = stack.pop();
          if(stack.isEmpty()) {
            break;
          }
          int distance = i - stack.peek() - 1;
          int heightOfPos = Math.min(height[i], height[stack.peek()]) - height[top];
          water += distance * heightOfPos;
        }

        stack.push(i);
      }

      return water;
  }

  public static void main(String[] args) {
    TrappedWater tw = new TrappedWater();
    int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(tw.trap(height));
  }
}
