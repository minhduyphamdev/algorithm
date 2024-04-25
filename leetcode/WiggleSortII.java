import java.util.*;

public class WiggleSortII {
  // O(nlogn)
  public void wiggleSort(int[] nums) {
    int[] sorted = nums.clone();
    Arrays.sort(sorted);
    int n = nums.length;
    int left = (n + 1) / 2 - 1;
    int right = n - 1;
    for(int i=0; i<n; i++) {
      nums[i] = i % 2 == 0 ? sorted[left--] : sorted[right--];
    }
  }

  public static void main(String[] args) {
    WiggleSortII wiggleSortII = new WiggleSortII();
    int[] nums = {1,5,1,1,6,4};
    wiggleSortII.wiggleSort(nums);
    for(int num: nums) {
      System.out.print(num + " ");
    }
  }
}
