import java.util.*;

public class SingleNumberII {
  public int singleNumber(int[] nums) {
    int ones = 0, twos = 0;
    for(int i = 0; i < nums.length; i++) {
      ones = (ones ^ nums[i]) & ~twos;
      twos = (twos ^ nums[i]) & ~ones;
    }
    return ones;
  }

  public static void main(String[] args) {
    SingleNumberII obj = new SingleNumberII();
    int[] nums = {2,2,3,2};
    System.out.println(obj.singleNumber(nums));
  }
}
