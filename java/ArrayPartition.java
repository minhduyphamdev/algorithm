package java;
import java.util.*;

public class ArrayPartition {
  // public int arrayPairSum(int[] nums) {
  //   if(nums == null || nums.length == 0) {
  //     return 0;
  //   }

  //   Arrays.sort(nums);
  //   int sum = 0;
  //   for(int i=0;i<nums.length;i+=2) {
  //     sum += nums[i];
  //   }

  //   return sum;
  // }

  public int arrayPairSum(int[] nums) {
    int[] exist = new int[20001];
		for (int i = 0; i < nums.length; i++) {
			exist[nums[i] + 10000]++;
		}
		int sum = 0;
		boolean odd = true;
		for (int i = 0; i < exist.length; i++) {
			while (exist[i] > 0) {
				if (odd) {
					sum += i - 10000;
				}
				odd = !odd;
				exist[i]--;
			}
		}
		return sum;
  }
  public static void main(String[] args) {
    ArrayPartition obj = new ArrayPartition();
    System.out.println(obj.arrayPairSum(new int[]{1,4,3,2}));
  }
}