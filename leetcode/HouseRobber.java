public class HouseRobber {
  public int rob(int[] nums) {
    if(nums.length == 1) {
      return nums[0];
    }

    
    if(nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }

    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for(int i=2;i<nums.length;i++) {
      dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
    }

    return dp[nums.length-1];
  }

  public static void main(String[] args) {
    HouseRobber hr = new HouseRobber();
    // System.out.println(hr.rob(new int[]{2,3,2}));
    System.out.println(hr.rob(new int[]{1,2,3,1}));
    // System.out.println(hr.rob(new int[]{1,2,3,4,5,6,7,8,9,10}));
    // System.out.println(hr.rob(new int[]{1,2,3,4,5,6,7,8,9,10,11}));
    // System.out.println(hr.rob(new int[]{1,2,3,4,5,6,7,8,9,10,11,12}));
    // System.out.println(hr.rob(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13}));
    // System.out.println(hr.rob(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14}));
    // System.out.println(hr.rob(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}));
    // System.out.println(hr.rob(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}));
    // System.out.println(hr.rob(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17}));
    // System.out.println(hr.rob(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18}));
    // System.out.println(hr.rob(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19}));
    // System.out.println(hr.rob(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}));
  }
}
 