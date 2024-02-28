import java.util.*;

public class AsteroidCollision {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    
    for(int i = 0; i<asteroids.length;i++) {
      if(stack.isEmpty() || asteroids[i] > 0) {
        stack.push(asteroids[i]);
      } else {
        while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() + asteroids[i] < 0) {
          stack.pop();
        }

        if(!stack.isEmpty() && stack.peek() + asteroids[i] == 0) {
          stack.pop();
        }
        else if(stack.isEmpty() || stack.peek() < 0){
          stack.push(asteroids[i]);
        }
      }
    }
    int[] sol = new int[stack.size()];

    for(int i = stack.size()-1; i>=0;i--) {
      sol[i] = stack.pop();
    }

    return sol;
  }

  public static void main(String[] args) {
    AsteroidCollision ac = new AsteroidCollision();
    // int[] asteroids = {5, 10, -5};
    // int[] asteroids = {8, -8};
    // int[] asteroids = {-2,-1,1,2};
    // int[] asteroids = {10, 2, -5};
    int[] asteroids = {1,-2,-2,-2};
    int[] sol = ac.asteroidCollision(asteroids);
    for(int i : sol) {
      System.out.println(i);
    }
  }
}
