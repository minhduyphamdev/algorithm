package java;
//https://leetcode.com/problems/longest-increasing-subsequence/?envType=study-plan-v2&envId=top-interview-150
import java.util.*;

public class LogestIncreasingSub {
  public int lengthOfLIS(int[] nums) {
    if(nums == null || nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length+1];
    dp[0] = 1;

    for(int i=1;i<nums.length;i++) {
      for(int j=0;j<i;j++) {
        if(nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j]+1);
        }
      }
      if(dp[i] == 0) {
        dp[i] = 1;
      }
    }

    int maxLen = 0;
    for(int ele: dp) {
      maxLen = Math.max(maxLen, ele);
    }

    return maxLen;
  }

  public static void main(String[] args) {
    LogestIncreasingSub obj = new LogestIncreasingSub();
    int[] nums = {10,9,2,5,3,7,101,18};
    System.out.println(obj.lengthOfLIS(nums));
  }
}
