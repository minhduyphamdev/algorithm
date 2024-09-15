package java;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
// https://leetcode.com/problems/snakes-and-ladders/solutions/3092663/beats-100-2ms-easy-solutions-fully-explained-c-java-python3/
public class SnakesAndLadders {
  public int snakesAndLadders(int[][] board) {
    int n = board.length;
    Map<Integer, Integer> distance = new HashMap<>(); // use this map to contains all number of move to reach the destination
    Queue<Integer> queue = new LinkedList<>(); // use this queue to contain list of position we need to move
    // stand at first position
    distance.put(1,0);
    queue.add(1);

    while(!queue.isEmpty()) {
      int pos = queue.poll();
      if(pos == n*n) return distance.get(pos);
      // check all nextMove in range [pos+1, Min(pos+6, n&^2)]
      for(int nextMove = pos+1; nextMove<= Math.min(pos+6,n*n);nextMove++) {
        // calculate nextPos with Boustrophedon style
        int nextPos = getNextPos(nextMove, n);
        int nextRow = nextPos / n;
        int nextCol = nextPos % n;
        // check if the nextPos has ladder or snake
        int suitablePos = board[nextRow][nextCol] == -1 ? nextMove: board[nextRow][nextCol];
        
        // add distance and position to queue
        if(!distance.containsKey(suitablePos)) {
          distance.put(suitablePos, distance.get(pos) + 1);
          queue.offer(suitablePos);
        }
      }
    }
  
    return -1;
  }

  public int getNextPos(int nextMove, int n) {
    // we need minus 1 because we start at 1 -> n*n
    int r1 = (nextMove-1) / n, c1 = (nextMove - 1) % n;
    // calculate just based on Boustrophedon style
    int row = n - 1 - r1;
    int col = (n-1-row) % 2  == 0 ? c1 : n - 1 - c1;

    return row*n + col;
  }

  public static void main(String[] args) {
    int[][] board = {
      {-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,-1},
      {-1,35,-1,-1,13,-1},
      {-1,-1,-1,-1,-1,-1},
      {-1,15,-1,-1,-1,-1},
    };
    SnakesAndLadders obj = new SnakesAndLadders();
    System.out.println(" ");
    System.out.println(obj.snakesAndLadders(board));
  }
}
