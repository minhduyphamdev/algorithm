package java;
import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum (int[] nums) {
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      int len = nums.length;
      Arrays.sort(nums);

      for(int i=0;i <len - 2; i++) {
        if(i >0 && nums[i] == nums[i-1]) {
          continue;
        }
        int target = -nums[i];
        int left = i+1;
        int right = len - 1;

        while(left < right) {
          int sum = nums[left] + nums[right];
          if(sum == target) {
            list.add(Arrays.asList(nums[i],nums[left],nums[right]));
            left ++;
            right --;

            while(left < right && nums[left] == nums[left -1]) {
              left++;
            }
            while(left < right && nums[right] == nums[right + 1]) {
              right --;
            }
          }
          else if(sum < target) {
            left++;

            while(left < right && nums[left] == nums[left -1]) {
              left++;
            }
          } else {
            right--;

            while(left < right && nums[right] == nums[right + 1]) {
              right --;
            }
          }
        }
      }

      return list;
    }

  public static void main(String[] args) {
    int [] nums = new int[] {-1,0,1,2,-1,4};
    List<List<Integer>> result = new ThreeSum().threeSum(nums);
    for (List<Integer> innerList : result) {
      for (Integer value : innerList) {
          System.out.print(value + " ");
      }
      System.out.println(); // Move to the next line after printing each inner list
    }
  }
}