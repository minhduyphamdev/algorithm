import java.util.Arrays;

public class FindtheMaximumLengthofValidSubsequenceI {
  public int maximumLength(int[] nums) {
        
        int n = nums.length;
        if(n==2) {
            return 2;
        }
        int[] dp = new int[n]; // dp[i] will store the length of the longest valid subsequence ending at index i
        
        // Initialize dp array
        Arrays.fill(dp, 1); // every single element is a valid subsequence of length 1
        
        int maxLen = 1; // initialize the maximum length found
        
        boolean flag = false;
        // Traverse through the array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if nums[j] and nums[i] can form a valid pair
                if (nums[j] < nums[i] && (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                    flag = true;
                }
            }
        }
        
        return maxLen;
    }

    public static void main(String[] args) {
        FindtheMaximumLengthofValidSubsequenceI fmlvs = new FindtheMaximumLengthofValidSubsequenceI();
        System.out.println(fmlvs.maximumLength(new int[]{4,2,6}));
    }
}
