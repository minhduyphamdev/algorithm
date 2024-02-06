import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    int len = nums.length;
    for(int i=0; i< len -3 ;i++) {
      if(i>0 && nums[i] == nums[i-1]) {
          continue;
        }
      for (int j=i+1; j< len-2; j++) {
          if(j>i+1 && nums[j] == nums[j-1]) {
            continue;
          }
          long sum =(long) target - nums[i] - nums[j];
          int left = j+1;
          int right = len - 1;
          
          while (left < right) {
            long temp = (long) nums[left] + nums[right];
            if(temp == sum) {
              result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
              left++;
               while(left < right && nums[left] == nums[left-1]) {
                left++;
              }
              right --;
              while(left < right && nums[right] == nums[right+1]) {
                right--;
              }
            
            }
            else if (temp < sum) {
              left ++;
                while(left < right && nums[left] == nums[left-1]) {
                left++;
              }
            }
            else {
              right --; 
              while(left < right && nums[right] == nums[right+1]) {
                right--;
              }
            }
          }

      }
    }
    
    return result;
  }

  public static void main(String[] args) {
    // int[] nums = new int[] {1,0,-1,0,-2,2};
    // int target = 0;
    // int[] nums = new int[] {2,2,2,2,2};
    // int target = 8;
    int [] nums = new int[] {-2,-1,-1,1,1,2,2};
    int target = 0;
    List<List<Integer>> result = new FourSum().fourSum(nums, target);
    for(List<Integer> i : result) {
      for(int j : i) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }
}
