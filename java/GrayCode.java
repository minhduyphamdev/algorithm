package java;
import java.util.*;

public class GrayCode {
  // comment: https://leetcode.com/problems/gray-code/solutions/400651/java-solutions-with-detailed-comments-and-explanations-backtracking-prepending/
  // check if two numbers are exactly differ by one bit
  // private boolean isValid(int n1, int n2) {
  //   int xor = n1 ^ n2;
  //   return xor != 0 && (xor & (xor - 1)) == 0;
  // }
  
  // Set<Integer> isContain;

  // public List<Integer> grayCode(int n) {
  //   List<Integer> res = new ArrayList<>(Arrays.asList(0));
  //   isContain = new HashSet<>();
  //   isContain.add(0);
  //   generateGrayCode(res, n);
  //   return res;
  // }

  // public boolean generateGrayCode(List<Integer> res, int n) {
  //   if(res.size() == (1<<n)) {
  //     return true;
  //   }

  //   for(int i=0;i<n;i++) {
  //     int ele = res.get(res.size()-1);
  //     int nextEle = ele ^ (1<<i);
  //     if(!isContain.contains(nextEle)) {
  //       res.add(nextEle);
  //       isContain.add(nextEle);
  //       boolean f = generateGrayCode(res, n);
  //       if(f) return true;
  //       isContain.remove(nextEle);
  //       res.remove(res.size()-1);
  //     }
  //   }

  //   return false;
  // }

  public List<Integer> grayCode(int n) {
    List<Integer> res = new ArrayList<>(Arrays.asList(0));
    for(int i=0;i<n;i++) {
      List<Integer> temp = new ArrayList<>(res);
      Collections.reverse(temp);
      int plus = 1 << i;

      for(int j=0;j<temp.size();j++) {
        temp.set(j,temp.get(j) + plus);
      }
      
      res.addAll(temp);
    }

    return res;
  }

  public static void main(String[] args) {
    GrayCode gc = new GrayCode();
    List<Integer> result = gc.grayCode(3);
    for (int code : result) {
      System.out.println(code);
    }
  }
}
