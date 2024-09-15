package java;
import java.util.*;

/*
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board?
 */
public class WordSearch {
  private boolean[][] isExist;
  public boolean exist(char[][] board, String word) {
    isExist = new boolean[board.length][board[0].length];
    for(int i=0;i<board.length;i++) {
      for(int j=0;j<board[0].length;j++) {
        if(board[i][j] == word.charAt(0) && searchWord(board,word,i,j,0)) {
          return true;
        }
      }
    }

    return false;
  }

  public boolean searchWord(char[][] board, String word, int row, int col, int pos) {
    if(pos == word.length()) {
      return true;
    }

    if(row<0 || row == board.length || col < 0 || col == board[0].length || word.charAt(pos) != board[row][col] || isExist[row][col]) {
      return false;
    }

    isExist[row][col] = true;

    if(searchWord(board, word, row-1, col, pos+1)
    || searchWord(board, word, row+1, col, pos+1)
    || searchWord(board, word, row, col-1, pos+1)
    || searchWord(board, word, row, col+1, pos+1)
    ) {
      return true;
    }

    isExist[row][col] = false;
    return false; 
  }

  public static void main(String[] args) {
    // char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    char[][] board = {{'C','A','A'}, {'A','A','A'}, {'B','C','D'}};
    String word = "AAB";
    System.out.println(new WordSearch().exist(board, word));
  }
}
