import java.lang.Math;
public class JumpSearch {
   public static void main(String args[]) {
      int n, key, index;
      int arr[] = {0, 6, 12, 14, 19, 22, 48, 66, 79, 88, 104, 126};
      System.out.println("Array elements are: ");
      for(int j = 0; j<arr.length; j++){
        System.out.print(arr[j] + " ");
      }
      n = 12;
      key = 0;
	  System.out.println("\nThe element to be searched: "+ key);
      index = jump_search(arr, n, key);
      if(index >= 0)
         System.out.print("The element is found at position " + (index+1));
      else
         System.out.print("Unsuccessful Search");
   }


   static int jump_search(int arr[], int n, int key) {
      int m, k;
      m = (int)Math.sqrt(n);
      k = m;
      while(arr[m] <= key && m < n) {
         m += k;
         if(m > n - 1)
            return -1;
      }
      
      // linear search on the block
      for(int j = m-k; j<m; j++) {
         if(arr[j] == key)
            return j;
      }
      return -1;
   }
}