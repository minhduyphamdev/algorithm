import java.util.*;

public class MaximumTotalDamageWithSpellCasting{
  public long maximumTotalDamage(int[] nums) {
    int max = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    for(int num: nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
        max = Math.max(num, max);
    }

    long[] dp = new long[max+1];
    for(int i=1;i<=max;i++) {
        int val = map.getOrDefault(i, 0);

        int sum = val * i;

        switch (i) {
            case 1:
                dp[i] = sum;
                break;
            case 2:
                dp[i] = Math.max(dp[i-1], sum);
                break;
            default:
                dp[i] = Math.max(dp[i-3] + sum, dp[i-1]);
                break;
        }
    }

    return dp[max];
  }

  public static void main(String[] args) {
      int[] nums = {7,1,6,6};
      System.out.println("");
      System.out.println(new MaximumTotalDamageWithSpellCasting().maximumTotalDamage(nums));  // Output: maximum total
  }
}