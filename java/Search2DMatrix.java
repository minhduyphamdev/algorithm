package java;
// problem list: https://leetcode.com/problems/search-a-2d-matrix/

public class Search2DMatrix {
  // public boolean searchMatrix(int[][] matrix, int target) {
  //   int row = matrix.length;
  //   int col = matrix[0].length;
  //   for(int i=0; i< row; i++) {
  //     if(matrix[i][0] <=target && target <= matrix[i][col-1]) {
  //       return binarySearch(matrix[i], target, col);
  //     }
  //   }

  //   return false;
  // }

  // public boolean binarySearch(int[] arr, int target, int len) {
  //   int left = 0;
  //   int right = len-1;

  //   while(left<=right) {
  //     int mid = left + (right-left) / 2;
  //     if(arr[mid] == target) {
  //       return true;
  //     }
  //     if(arr[mid] < target) {
  //       left = mid + 1;
  //     }
  //     else {
  //       right = mid - 1;
  //     }
  //   }

  //   return false;
  // }

  public boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int left = 0;
    int right = rows*cols-1;

    while(left<=right) {
      int mid = left + (right-left) / 2;
      int midElement = matrix[mid/cols][mid%cols];

      if(midElement == target) {
        return true;
      }
      else if(midElement < target) {
        left = mid + 1;
      }
      else {
        right = mid - 1;
      }
    }

    return false;
  }

//   public boolean searchMatrix(int[][] matrix, int target) {
//     int row =0;
//     int col = 0;
//     int m = matrix.length;
//     int n = matrix[0].length;

//     while(row<m && col <n) {
//         int midRow = row+(m-row) /2;
//         int midCol = col + (n-col) /2;

//         if(matrix[midRow][midCol] == target) {
//             return true;
//         }
//         else if(matrix[midRow][midCol] < target) {
//             if(matrix[midRow][matrix[0].length-1] < target) {
//                 row++;
//             }
//             else {
//                col++;
//             }
//         }
//         else {
//             if(matrix[midRow][0] > target) {
//                 m--;
//             }
//             else {
//                 n--;
//             }
//         }
//     }

//     return false;
// }

  public static void main(String[] args) {
    Search2DMatrix obj = new Search2DMatrix();
    int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    int target = 3;
    System.out.println(obj.searchMatrix(matrix, target));
  }
}
