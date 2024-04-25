import java.util.*;

public class KthLargestElementInArray {
  // public int findKthLargest(int[] nums, int k) {
  //   PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
  //   for(int num: nums) {
  //     pq.add(num);
  //     if(pq.size() > nums.length-k+1) {
  //       pq.poll();
  //     }
  //   }

  //   return pq.peek();
  // }

  public int findKthLargest(int[] nums, int k) {
    return quickSelect(nums, 0, nums.length - 1, nums.length - k);
  }

  public int quickSelect(int[] nums, int left, int right, int target) {
    if( left == right) {
        return nums[left];
    }

    int pivot = partition(nums, left, right);
    if(pivot == target) {
        return nums[target];
    }

    else if(pivot < target) {
        return quickSelect(nums,pivot+1, right, target);
    }

    return quickSelect(nums,left,pivot-1,target);
  }

  public int partition(int[] nums, int left, int right) {
    int pivot = left + new Random().nextInt(right-left+1);
    swap(nums, pivot, right);

    int sortedIndex = left;
    for(int i=left; i<right;i++) {
        if(nums[i] < nums[right]) { 
            swap(nums, sortedIndex++, i);
        }
    }

    swap(nums, sortedIndex, right);
    return sortedIndex;
  }

  public void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }

  public static void main(String[] args) {
    KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
    int[] nums = {3,2,1,5,6,4};
    int k = 2;
    System.out.println(kthLargestElementInArray.findKthLargest(nums, k));
  }
}
