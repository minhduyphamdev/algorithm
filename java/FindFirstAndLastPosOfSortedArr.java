package java;
public class FindFirstAndLastPosOfSortedArr {
  public int[] searchRange(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while(left<right) {
        int mid = left + (right-left) /2;
        if(nums[mid] == target) {
            return findRange(nums,target,mid);
        }
        else if (nums[mid] < target) {
            left = mid +1;
        }
        else {
            right = mid - 1;
        }
    }

      return new int[] {-1,-1};
  }

  public int[] findRange(int[] arr, int target, int pos) {
      int left = pos;
      int right = pos;
      while(left -1 >= 0 && arr[left-1] == target) {
          left = left -1;
      }

      while(right+1 < arr.length && arr[right+1] == target) {
          right = right +1;
      }

      return new int[] {left, right};
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1};
    int target = 1;
    FindFirstAndLastPosOfSortedArr obj = new FindFirstAndLastPosOfSortedArr();
    
  }
}
