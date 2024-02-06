// https://leetcode.com/problems/subsets/description/
import java.util.ArrayList;
import java.util.List;

public class SubSets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

        findComb(nums, result, new ArrayList<Integer>(),0);
        return result;
    }

    private void findComb(int[] nums, List<List<Integer>> result, List<Integer> temp, int pos) {
      result.add(new ArrayList<Integer>(temp));
      for(int i = pos; i < nums.length; i++ ) {
        temp.add(nums[i]);
        findComb(nums, result, temp,i+1);
        temp.remove(temp.size() -1);
      }
    }

    public static void main(String[] args) {
      SubSets obj = new SubSets();
      int[] nums = {1,2,3};
      List<List<Integer>> result = obj.subsets(nums);

      for(List<Integer> list : result) {
        for(Integer num : list) {
          System.out.print(num + " ");
        }
        System.out.println();
      }
    }
}
