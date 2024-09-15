package java;
import java.util.*;

public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candicates, int target) {
    List<List<Integer>> arr = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    int pos = 0;

    Arrays.sort(candicates);
    calculateSum(candicates, target, arr, curr, pos);

    return arr;
  }
  public void calculateSum(int[] candicates, int target, List<List<Integer>> arr,List<Integer> curr, int pos) {
    if(target == 0) {
      arr.add(new ArrayList<>(curr));
      return;
    }

    for(int i = pos; i< candicates.length; i++) {
        if(i>pos && candicates[i] == candicates[i-1]) {
          continue;
        }

        int minus = target - candicates[i];
        if(minus >= 0) {
          curr.add(candicates[i]);
          calculateSum(candicates, minus, arr, curr, i);
          curr.remove(curr.size()-1);
        }
        else {
          return;
        }
    }

  }
  public static void main(String[] args) {
      CombinationSum combinationSum = new CombinationSum();
      int[] candidates = {8,7,4,3};
      int target = 11;
      List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

      // Print the result
      for (List<Integer> combination : result) {
          System.out.println(combination);
      }
  }
}
