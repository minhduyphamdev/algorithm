package java;
// problem: https://leetcode.com/problems/contains-duplicate-ii/?envType=study-plan-v2&envId=top-interview-150
import java.util.*;

public class ContainsDuplicateII {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if(nums == null || nums.length == 0) {
      return false;
    }

    Map<Integer, Integer> map = new HashMap<>();
    for(int i=0;i<nums.length;i++) {
      if(map.containsKey(nums[i]) && i - map.get(nums[i]) <=k) {
        return true;
      }

      map.put(nums[i],i);
    }

    return false;
  }

  public static void main(String[] args) {
    ContainsDuplicateII cd = new ContainsDuplicateII();
    int[] nums = new int[]{1,0,1,1};
    int k = 1;
    System.out.println(cd.containsNearbyDuplicate(nums, k));
  }
}
