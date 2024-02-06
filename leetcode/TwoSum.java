//problem: https://leetcode.com/problems/two-sum/description/

import java.util.HashMap;

public class TwoSum {
   public int[] twoSum (int[] nums, int target) {
    if(nums.length == 2) {
      return new int[] {0,1};
    }

    HashMap<Integer,Integer> map = new HashMap<>();

    for(int i=0;i<nums.length; i++) {
        int remain = target - nums[i];
        if(!map.containsKey(remain)) {
          map.put(nums[i],i);
        }
        else {
          return new int[] {map.get(remain),i};
        }
      
    }

    throw new IllegalArgumentException("Nums not found");
  }
}