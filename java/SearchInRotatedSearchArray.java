package java;
public class SearchInRotatedSearchArray {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while(left <= right) {
        int mid = left + (right-left) /2;
        if(nums[mid] ==  target) {
            return mid;
        }

        // check which half is sorted
        if(nums[left] < nums[mid])
        {
          // left half is sorted
          if(nums[left] <=target && target < nums[mid]) {
            right = mid -1;
          }
          else {
            left = mid + 1;
          }
        }
        else {
          // right half is sorted
          if(nums[mid] == nums[left] || (nums[mid] < target && target <= nums[right])) {
            left = mid + 1;
          }
          else {
            right = mid - 1;
          }
        }
        
    }


    return -1;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {4,5,6,7,0,1,2};
    int target = 0;
    System.out.println(new SearchInRotatedSearchArray().search(nums, target));
  }
}
