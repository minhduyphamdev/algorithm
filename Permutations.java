// https://leetcode.com/problems/permutations/

import java.util.ArrayList;
import java.util.List;

public class Permutations {
   public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        findComb(nums, result, new ArrayList<Integer>());
        return result;
    }

    public void findComb(int[] nums, List<List<Integer>> result, List<Integer> temp) {
      if(temp.size() == nums.length) {
        result.add(new ArrayList<Integer>(temp));
        return;
      }
      for(int i = 0; i < nums.length; i++ ) {
        if(temp.contains(nums[i])) {
          continue;
        }
        temp.add(nums[i]);
        findComb(nums, result, temp);
        temp.remove(temp.size() -1);
      }
    }

    public static void main(String[] args) {
      Permutations obj = new Permutations();
      int[] nums = {1,2,3};
      List<List<Integer>> result = obj.permute(nums);

      for(List<Integer> list : result) {
        for(Integer num : list) {
          System.out.print(num + " ");
        }
        System.out.println();
      }
    }
}
