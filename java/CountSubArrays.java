package java;
public class CountSubArrays {
  public long countSubarrays(int[] nums, int k) {
    long max = nums[0];
    int left = 0, right = 0,count = 0;
    long total = 0;
    for(int num: nums) {
      max = Math.max(num,max);
    }

    while(right<nums.length) {
      if(nums[right] == max) {
        count++;
      }

      while(count>=k) {
        total += nums.length - right;
        if(nums[left] == max) {
          count--;
        }
        left++;
      }

      right++;
    }

    return total;
  }

  public static void main(String[] args) {
    CountSubArrays csa = new CountSubArrays();
    int[] nums = {1,3,2,3,3};
    System.out.println(csa.countSubarrays(nums, 2));
  }
}
