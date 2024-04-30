// Java program for implementation of Heap Sort
package geekforgeeks;

import java.util.Collection;
import java.util.Collections;

public class HeapSort {
  public void sort(int arr[]) {
      int len = arr.length;

      for(int i=len/2-1;i>=0;i--) {
        heapify(arr, len, i);
      }

      for(int i=len-1;i>=0;i--) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;

        heapify(arr, i, 0);
      }
  }

  // To heapify a subtree rooted with node i which is
  // an index in arr[]. n is size of heap
  void heapify(int arr[], int N, int i)
  {
    int largestPos = i;
    int l = 2*i+1;
    int r = 2*i+2;

    // if you want to change maxHeap to sort asc, change to >
    if(l<N && arr[l] < arr[largestPos]) {
      largestPos = l;
    }

    if(r<N && arr[r] < arr[largestPos]) {
      largestPos = r;
    }

    if(largestPos != i ) {
      int temp = arr[i];
      arr[i] = arr[largestPos];
      arr[largestPos] = temp;
    
      heapify(arr, N, largestPos);
    }
  }

  /* A utility function to print array of size n */
  static void printArray(int arr[])
  {
      int N = arr.length;

      for (int i = 0; i < N; ++i)
          System.out.print(arr[i] + " ");
      System.out.println();
  }

  // Driver's code
  public static void main(String args[])
  {
      int arr[] = { 12, 11, 13, 5, 6, 7 };

      // Function call
      HeapSort ob = new HeapSort();
      ob.sort(arr);

      System.out.println("Sorted array is");
      printArray(arr);
  }
}
