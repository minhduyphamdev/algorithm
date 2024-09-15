package java;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/contest/biweekly-contest-139/problems/find-a-safe-walk-through-a-grid/
public class FindASafeWorkThroughAGrid {
  public boolean findSafeWalk(List<List<Integer>> grid, int health) {
    int m = grid.size();
    int n = grid.get(0).size();

    // Check if the starting cell is unsafe and health is not sufficient
    if (grid.get(0).get(0) == 1 && health <= 1) {
      return false;
    }

    // Directions for moving right, down, left, up
    int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[m][n];

    // Start BFS from the top-left corner
    queue.offer(new int[] { 0, 0, health }); // {row, col, current_health}
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int x = current[0];
      int y = current[1];
      int currHealth = current[2];

      // Check if we've reached the bottom-right corner
      if (x == m - 1 && y == n - 1) {
        return currHealth - grid.get(x).get(y) > 0;
      }

      // Explore neighbors
      for (int[] direction : directions) {
        int newX = x + direction[0];
        int newY = y + direction[1];

        // Check for boundaries
        if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
          // Determine new health
          int newHealth = currHealth - grid.get(newX).get(newY);

          // Proceed if new health is positive and not visited
          if (newHealth > 0 && !visited[newX][newY]) {
            visited[newX][newY] = true;
            queue.offer(new int[] { newX, newY, newHealth });
          }
        }
      }
    }

    return false; // Could not reach the bottom-right corner
  }

  public static void main(String[] args) {
    FindASafeWorkThroughAGrid solution = new FindASafeWorkThroughAGrid();
    List<List<Integer>> grid = new ArrayList<>();
    List<Integer> row1 = new ArrayList<>();
    row1.add(1);
    row1.add(1);
    row1.add(1);
    List<Integer> row2 = new ArrayList<>();
    row2.add(1);
    row2.add(0);
    row2.add(1);
    List<Integer> row3 = new ArrayList<>();
    row3.add(1);
    row3.add(1);
    row3.add(1);

    grid.add(row1);
    grid.add(row2);
    grid.add(row3);
    int health = 4;

    boolean result = solution.findSafeWalk(grid, health);
    System.out.println(result); // Should print false
  }
}