package java;
import java.util.*;

public class KthSmallestElementInASortedMatrix {
  // brute force
  // public int kthSmallest(int[][] matrix, int k) {
  //   int n = matrix.length;
  //   int[] sorted = new int[n*n];
  //   for(int i=0;i<n;i++) {
  //     for(int j=0;j<n;j++) {
  //       sorted[i*n+j] = matrix[i][j];
  //     }
  //   }

  //   Arrays.sort(sorted);

  //   return sorted[k-1];
  // }

  //binary search
  // public int countLessThanPos(int[][] matrix, int n, int target) {
  //   int i = n-1, j=0, count = 0;
  //   while(i>=0 && j<n) {
  //     if(matrix[i][j] > target) {
  //       i--;
  //     }
  //     else {
  //       count+=i+1;
  //       j++;
  //     }
  //   }

  //   return count;
  // }

  // public int kthSmallest(int[][] matrix, int k) {
  //   int left = matrix[0][0], n = matrix.length, right = matrix[n-1][n-1];
  //   while(left < right) {
  //     int mid = left + (right-left)/2;
  //     int count = countLessThanPos(matrix, n, mid);
  //     if(count < k) {
  //       left = mid +1;
  //     }
  //     else {
  //       right = mid;
  //     }
  //   }

  //   return right;
  // }

  // Priority QUeue ( only save kth smallest elements)
  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    KthLargestElementInArray<Integer> pq = new KthLargestElementInArray<>(Collections.reverseOrder());
    for(int i=0;i<n;i++) {
      for(int j=0;j<n;j++) {
        pq.offer(matrix[i][j]);
        if(pq.size() > k) {
          pq.poll();
        }
      }
    }

    return pq.peek();
  }

  public static void main(String[] args) {
    System.out.println(new KthSmallestElementInASortedMatrix().kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8));
  }
}
