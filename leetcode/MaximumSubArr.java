// problem: https://leetcode.com/problems/maximum-product-subarray/

public class MaximumSubArr {
  public int maxProduct(int[] nums) {
    int maxCurr = nums[0];
    int minCurr = nums[0];
    int result = nums[0];
    for(int i=1;i<nums.length;i++) {
      if(nums[i]<0) {
        int temp = maxCurr;
        maxCurr = minCurr;
        minCurr = temp;
      }

      maxCurr = Math.max(nums[i],nums[i] *maxCurr);
      minCurr = Math.min(nums[i],nums[i] * minCurr);

      result = Math.max(result,maxCurr);
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = {2,3,-1,5,6};
    System.out.println(new MaximumSubArr().maxProduct(nums));
  }
}
