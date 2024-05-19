package viblo;

import java.util.Random;
import java.util.Scanner;

public class MatrixGameBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlayers = scanner.nextInt();
        int[] triplet = new int[3];
        for (int i = 0; i < 3; i++) {
            triplet[i] = scanner.nextInt();
        }
        int[][] myBoard = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                myBoard[i][j] = scanner.nextInt();
            }
        }
        int[][][] opponentsBoards = new int[numberOfPlayers - 1][9][9];
        for (int p = 0; p < numberOfPlayers - 1; p++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    opponentsBoards[p][i][j] = scanner.nextInt();
                }
            }
        }

        System.out.println(findPositionToPutPiece(myBoard, triplet));

       

        scanner.close();
    }

    private static int findPositionToPutPiece(int[][] myBoard, int[] triplet) {
        if(checkDigitsCount(triplet)) {
          int count = 0;
          while(true) {
            int rand = new Random().nextInt(14) + 12;
            if(myBoard[rand/9*3][rand%9] == -1) {
              return rand;
            }
            count++;
            if(count == 5) {
              break;
            }
          }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (myBoard[i*3][j] == -1) {
                    return i*9+j;
                }
            }
        }
        return -1;
    }
    

    // calculate score
    public static int calculateScore(int[][] myBoard, int[] triplet, int x, int y) {
        return new Random().nextInt(+y+triplet[0] + triplet[1] + triplet[2]);
    }

    public static boolean checkDigitsCount(int[] triplet) {
      int count7And8 = 0;
      int count9And10 = 0;
  
      for (int digit : triplet) {
          if (digit == 7 || digit == 8) {
              count7And8++;
          } else if (digit == 9 || digit == 10) {
              count9And10++;
          }
      }
  
      return count9And10 > count7And8;
  }
}


//
// 2
// 9 9 9
// 9 9 8 9 -1 9 9 -1 -1 7 10 7 7 -1 9 7 -1 -1 9 10 8 9 -1 10 10 -1 -1 -1 10 7 9 9 -1 -1 -1 8 -1 10 9 9 8 -1 -1 -1 10 -1 8 8 8 8 -1 -1 -1 7 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
// 7 9 9 9 -1 7 9 -1 -1 10 10 7 10 -1 9 7 -1 -1 9 10 8 9 -1 10 10 -1 -1 -1 10 7 9 9 -1 -1 -1 8 -1 10 9 9 8 -1 -1 -1 10 -1 8 8 7 8 -1 -1 -1 7 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1