package java;
public class MissingNumber {
  public int missingNumber(int[] nums) {
    int xor = 0;
    for(int i=0;i<nums.length;i++) {
      xor = xor ^ i ^ nums[i];
    }
    xor = xor ^ nums.length;

    return xor;
  }

  public static void main(String[] args) {
    MissingNumber mn = new MissingNumber();
    int[] nums = {0,1,3};
    System.out.println(mn.missingNumber(nums));
  }
}
