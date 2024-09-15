package java;
// problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

public class FindMinimumOfSortedArr {

  public int findMin(int[] nums) {
    int left = 0 ;
    int right = nums.length - 1;

    while(left<right) {
      int mid = left + (right - left) / 2;
      if(nums[mid] <= nums[right]) {
        right = mid;
      }
      else {
        left = mid+1;
      }
    }

    return nums[right];
  }

  public static void main(String[] args) {
    FindMinimumOfSortedArr findMinimumOfSortedArr = new FindMinimumOfSortedArr();
    // int[] nums = {3,4,5,1,2};
    int[] nums = {4,5,6,7,0,1,2};
    System.out.println(findMinimumOfSortedArr.findMin(nums));
  }
}
