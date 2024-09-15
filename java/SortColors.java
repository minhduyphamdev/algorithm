package java;
public class SortColors {
  // public void sortColors(int[] nums) {
  //   int k = 0;
  //   int num1 = 0;
  //   int[] newArr = new int[nums.length];
  //   for(int i=0; i < nums.length; i++) {
  //       if(nums[i]==0) {
  //           newArr[k++] = 0;
  //       }
  //       else if(nums[i]==1) {
  //           num1++;
  //       }
  //   }

  //   for(int i=0; i<num1;i++) {
  //       newArr[k++] = 1 ;
  //   }

  //   while(k<nums.length) {
  //       newArr[k++] = 2;
  //   }

  //   System.arraycopy(newArr, 0, nums, 0, nums.length);
  // }

  public void sortColors(int[] nums) {
    int low = 0;
    int current = 0;
    int high = nums.length-1;

    while(current<=high) {
      if(nums[current] == 0) {
        swap(nums, low, current);
        low++;
        current++;
      }
      else if(nums[current] == 2) {
        swap(nums, current, high);
        high--;
      }
      else {
        current++;
      }
    }
  }

  public void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }

  public static void main(String[] args) {
    SortColors sc = new SortColors();
    int[] nums = {2,0,2,1,1,0};
    sc.sortColors(nums);
    for(int i=0; i<nums.length; i++) {
      System.out.println(nums[i]);
    }
  }
}
