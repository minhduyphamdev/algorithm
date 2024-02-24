public class MaximumCountOfPositiveIntegerAndNegativeInteger {
  public int maximumCount(int[] nums) {
    int maxPosOfNegative = -1;
    int left = 0;
    int right = nums.length - 1;
    while(left <= right) {
      int mid = left + (right-left) /2;
      if(nums[mid] < 0) {
        maxPosOfNegative = mid;
        left = mid +1;
      }
      else {
        right = mid - 1;
      }
    }

    int numsOfZero = 0;
    for(int i=maxPosOfNegative+1;i<nums.length;i++) {
      if(nums[i] == 0) {
         numsOfZero++;
      }
      else {
        break;
      }
    }

    return Math.max(maxPosOfNegative +1, nums.length - maxPosOfNegative -1 - numsOfZero);
  }

  public static void main(String[] args) {
    // System.out.println(new MaximumCountOfPositiveIntegerAndNegativeInteger().maximumCount(new int[]{-1,0,3,5,9,12}));
    // System.out.println(new MaximumCountOfPositiveIntegerAndNegativeInteger().maximumCount(new int[]{-2,-1,-1,1,2,3}));
    System.out.println(new MaximumCountOfPositiveIntegerAndNegativeInteger().maximumCount(new int[]{-3,-2,-1,0,0,1,2}));
  }
}
