package java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
      public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        findComb(candidates, target, result, new ArrayList<Integer>(), 0);
        return result;
    }

    public void findComb(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, int pos) {
        if(target == 0) {
          result.add(new ArrayList<Integer>(temp));
          return;
        }

        for(int i=pos; i < candidates.length; i++) {
          if(i > pos && candidates[i] == candidates[i-1]) {
            continue;
          }

          if(candidates[i] > target) {
            break;
          }

          temp.add(candidates[i]);
          findComb(candidates, target - candidates[i], result, temp, i+1);
          temp.remove(temp.size()-1);

        }
    }


    public static void main(String[] args) {
      CombinationSumII obj = new CombinationSumII();
      int[] candidates = {10,1,2,7,6,1,5};
      int target = 8;
      List<List<Integer>> result = obj.combinationSum2(candidates, target);

      for(List<Integer> list : result) {
        for(Integer num : list) {
          System.out.print(num + " ");
        }
        System.out.println();
      }
    }
}
