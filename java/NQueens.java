package java;
import java.util.*;

public class NQueens {
  public List<List<String>> solveNQueens(int n) {
      List<List<String>> result = new ArrayList<>();
      char[][] matrixQueens = new char[n][n];
      findAllNQueens(result, matrixQueens, n, 0);
      return result;
  }
  
  //pos is row
  public void findAllNQueens(List<List<String>> result, char[][] matrixQueens, int n, int pos) {
  
    String str = "";
    if(pos == n) {
      List<String> ans = new ArrayList<>();
      for(char[] row: matrixQueens) {
        str="";
        for (char ele: row) {
          if(ele == 'Q') {
            str+='Q';
          }
          else {
            str+='.';
          }
        }
        ans.add(str);
      }

      result.add(ans);
      return;
    }

    for(int i=0;i<n;i++) {
      if(pos ==0 || isValid(matrixQueens,n, pos,i)) {
        matrixQueens[pos][i] = 'Q';
        findAllNQueens(result, matrixQueens, n, pos+1);
        matrixQueens[pos][i]='.';
      }
    }
  }

  public boolean isValid(char[][] matrixQueens, int n, int row, int col) {
    // check row
    for(int i = 0 ; i<n;i++) {
      if(matrixQueens[i][col] =='Q') {
        return false;
      }
    }

    // check col
    for(int i=0;i<n;i++) {
      if(matrixQueens[row][i] =='Q') {
        return false;
      }
    }

    // upper left
    for(int r= row, c=col; r>=0 && c>=0;r--,c--) {
      if(matrixQueens[r][c] =='Q') {
        return false;
      }
    }

    // upper right 
    for(int r=row,c=col;r>=0&& c<n;r--,c++) {
      if(matrixQueens[r][c] =='Q') {
        return false;
      }
    }

    // lower left 
    for(int r=row,c=col;r<n&&c>=0;r++,c--) {
      if(matrixQueens[r][c] =='Q')  return false;
    }

     // lower right 
     for(int r=row,c=col;r<n&&c<n;r++,c++) {
      if(matrixQueens[r][c] =='Q')  return false;
    }
    
    return true;
  }

  public static void main(String[] args) {
    List<List<String>> ans = new NQueens().solveNQueens(4);
    for(List<String> res: ans) {
      for(String item: res) {
        System.out.print(res+",");
      }
      System.out.println();
    }
  }
}
