//problem: https://leetcode.com/problems/two-sum/description/

import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

public class TwoSum {
  //  public int[] twoSum (int[] nums, int target) {
  //   if(nums.length == 2) {
  //     return new int[] {0,1};
  //   }

  //   HashMap<Integer,Integer> map = new HashMap<>();

  //   for(int i=0;i<nums.length; i++) {
  //       int remain = target - nums[i];
  //       if(!map.containsKey(remain)) {
  //         map.put(nums[i],i);
  //       }
  //       else {
  //         return new int[] {map.get(remain),i};
  //       }
      
  //   }

  //   throw new IllegalArgumentException("Nums not found");
  // }


  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<Integer,Integer>();

    for(int i = 0;i < nums.length;i++) {
      int remain = target - nums[i];
      if(map.get(remain) != null) {
        return new int[] {map.get(remain),i};
      } 

      map.put(nums[i], i);
    }

    throw new IllegalArgumentException("Not exist two sum");
  }

  public static void main(String[] args) {
    TwoSum ts = new TwoSum();
    int[] nums = {2,7,11,15};
    int target = 9;
    int[] result = ts.twoSum(nums,target);
    System.out.println(result[0] + " " + result[1]);
  }

}