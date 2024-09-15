package java;
//problem: https://leetcode.com/problems/summary-ranges/description/?envType=study-plan-v2&envId=top-interview-150
import java.util.*;


public class SummaryRanges {
  public List<String> summaryRanges(int[] nums) {
    if(nums.length == 0) {
      return new ArrayList<>();
    }
    List<String>result = new ArrayList<> ();
    List<Integer> temp = new ArrayList<> ();
    temp.add(nums[0]);
    for(int i=1;i<nums.length;i++) {  
      int last = temp.get(temp.size() -1);
      if(nums[i] == last+1) {
        temp.add(nums[i]);
      }
      else {
        if(temp.size() == 1) {
          result.add(String.valueOf(last));
          temp.clear();
        }
        else {
          result.add(temp.get(0) + "->"+last);
          temp.clear();
        }

        temp.add(nums[i]);
      }
    }

    int last = temp.get(temp.size() -1);
    if(temp.size() == 1) {
      result.add(String.valueOf(last));
    }
    else {
      result.add(temp.get(0) + "->"+last);
    }

    return result;
  }
  public static void main(String[] args) {
    // int[] nums = new int[] {0,1,2,4,5,7};
    int[] nums = new int[] {0,2,3,4,6,8,9};
    List<String> result = new SummaryRanges().summaryRanges(nums);
    for(String a: result) {
      System.out.println(a);
    }
  }
}
