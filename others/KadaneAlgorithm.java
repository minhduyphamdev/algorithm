public class KadaneAlgorithm {
  public int findMaxSubString(int[] nums) {
    int maxEndingHere = nums[0];
    int maxSoFar = nums[0];

    for(int i=1;i<nums.length;i++) {
      maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
      maxSoFar = Math.max(maxEndingHere, maxSoFar);
    }

    return maxSoFar;
  }

  public static void main(String[] args) {
    KadaneAlgorithm ka = new KadaneAlgorithm();
    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(ka.findMaxSubString(nums));
  }
}
