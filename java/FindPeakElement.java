package java;
public class FindPeakElement {
  public int findPeakElement(int[] nums) {
    int length = nums.length;
    int left = 0;
    int right = length-1;

    while(left <= right) {
      int mid = left + (right - left) / 2;
      if(mid+1 > length-1 || nums[mid] > nums[mid+1]) {
        if(mid - 1 < 0 ||  nums[mid] > nums[mid-1]) {
          return mid;
        }
        else {
          right = mid - 1;
        }
      }
      else {
        left = mid + 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    FindPeakElement fpe = new FindPeakElement();
    // int[] arr = new int[] {1,2,3,1};
    int[] arr = new int[] {1,2,1,3,5,6,4};
    System.out.println(fpe.findPeakElement(arr));
  }
}
 