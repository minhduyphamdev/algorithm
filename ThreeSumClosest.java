import java.util.Arrays;

public class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int sum = Integer.MAX_VALUE;
    int len = nums.length;
    for(int i=0; i< len -2; i++) {
      int left = i+1;
      int right = len-1;
      int currSum = Math.abs(nums[i] + nums[left] + nums[right] - target);
      if(currSum == 0 ) {
        return 0;
      }
      else if(currSum < sum) {
        sum = currSum;
        left ++;
        right --;

        
      }
      
    }
  }
}
