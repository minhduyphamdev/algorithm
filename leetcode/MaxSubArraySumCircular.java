public class MaxSubArraySumCircular {
  //find maximum between maxSub in normal array and total - minSub in circular array
  // reference: https://leetcode.com/problems/maximum-sum-circular-subarray/solutions/178422/one-pass/?envType=study-plan-v2&envId=top-interview-150
  public int maxSubarraySumCircular(int[] nums) {
    int maxTemp = nums[0];
    int maxSum = nums[0];
    int total = nums[0];
    int minTemp = nums[0];
    int minSum = nums[0];

    for(int i=1;i<nums.length;i++) {
      // find maximum sub array
      maxTemp = Math.max(nums[i], maxTemp + nums[i]);
      maxSum = Math.max(maxTemp, maxSum);

      // find minimum sub array
      minTemp = Math.min(nums[i], minTemp + nums[i]);
      minSum = Math.min(minTemp, minSum);

      // find total sum of array
      total += nums[i];
    }

    if(maxSum < 0) return maxSum;


    return Math.max(maxSum, total - minSum);
  }

  public static void main(String[] args) {
    MaxSubArraySumCircular msc = new MaxSubArraySumCircular();
    int[] nums = {-3,-2,-3};
    System.out.println(msc.maxSubarraySumCircular(nums));
  }
}
