public class NextPermutation {

  public void reverse(int[] nums, int start, int end) {
    while(start<end) {
      swapElementsInArr(nums, start, end);
      start++;
      end --;
    }
  }
  public void swapElementsInArr(int [] nums, int numPos1, int numPos2) {
    int temp = nums[numPos1];
    nums[numPos1] = nums[numPos2];
    nums[numPos2] = temp;
  }
  public void nextPermutation(int[] nums) {
    int len = nums.length;
    int i = len-2;
    while(i>=0 && nums[i] >=nums[i+1]) {
      i--;
    }

    if(i>=0) {
      int j =len-1;
      while(nums[i]>=nums[j]) {
        j--;
      }

      swapElementsInArr(nums,i,j);
    }

    reverse(nums, i + 1, len - 1);

  }

  public static void main(String[] args) {
    int[] nums = new int[]{2,3,1,3,3};
    new NextPermutation().nextPermutation(nums);
    for(int num: nums) {
      System.out.print(num+ " ");
    }

  }
}
