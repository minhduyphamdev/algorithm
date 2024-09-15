package java;
import java.util.*;

public class LargestNumber {
  public String largestNumber(int[] nums) {
    String[] arr = new String[nums.length];
    for(int i=0;i<nums.length;i++) {
      arr[i] = String.valueOf(nums[i]);
    }

    Arrays.sort(arr,(a,b) -> (b+a).compareTo(a+b));

    StringBuilder builder = new StringBuilder();
    for(String s: arr) {
      builder.append(s);
    }

    String res = builder.toString();

    if(res.charAt(0) == '0') {
      return "0";
    }

    return res;
  }

  public static void main(String[] args) {
    LargestNumber obj = new LargestNumber();
    System.out.println(obj.largestNumber(new int[]{3,30,34,5,9}));
  }
}
