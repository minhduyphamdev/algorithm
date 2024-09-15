package java;
public class LongestIncreasingSubsequence {
  public static int maxRef;

  public static int lsi(int[] arr, int n) {
    int  res = 1;
    int max_ending_here = 1;

    for(int i=1;i<n;i++) {
      res = lsi(arr,i);
      if(arr[i-1] < arr[n-1] && res+1 > max_ending_here) {
        max_ending_here = res + 1;
      }
    }

    if(maxRef < max_ending_here) {
      maxRef = max_ending_here;
    }

    return max_ending_here;
  }

  public static int findLsi(int[] arr,int n) {
    maxRef = 1;
    
    lsi(arr,n);

    return maxRef;
  }

  public static void main(String[] args) {
    int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
    int n = arr.length;

    // Function call
    System.out.println("Length of lis is "
                       + findLsi(arr, n));
  }

}
 