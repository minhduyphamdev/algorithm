// https://leetcode.com/problems/subsets/description/
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class SubSetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        findComb(nums, result, new ArrayList<Integer>(),0);
        return result;
    }

    private void findComb(int[] nums, List<List<Integer>> result, List<Integer> temp, int pos) {
      result.add(new ArrayList<Integer>(temp));
      for(int i = pos; i < nums.length; i++ ) {
        if(i > pos && nums[i] == nums[i-1]) {
          continue;
        }
        temp.add(nums[i]);
        findComb(nums, result, temp,i+1);
        temp.remove(temp.size() -1);
      }
    }

    public static void main(String[] args) {
      SubSetsII obj = new SubSetsII();
      int[] nums = {1,2,2};
      List<List<Integer>> result = obj.subsetsWithDup(nums);

      for(List<Integer> list : result) {
        for(Integer num : list) {
          System.out.print(num + " ");
        }
        System.out.println();
      }
    }
}
