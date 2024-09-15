package java;

import java.util.Arrays;

public class MergedSortedArray {
  // public void merge(int[] nums1, int m, int[] nums2, int n) {
  //   int k = nums1.length-1;
  //   m--;
  //   n--;
  //   while(m>=0&&n>=0) {
  //     if(nums1[m] >= nums2[n]) {
  //       nums1[k] = nums1[m];
  //       m--;
  //     } else {
  //       nums1[k] = nums2[n];
  //       n--;
  //     }
  //     k--;
  //   }

  //   while(m>=0) {
  //     nums1[k--] = nums1[m--];
  //   }

  //   while(n>=0) {
  //     nums1[k--] = nums2[n--];
  //   }
  // }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    for(int j=0, i=m; j<n;j++,i++) {
      nums1[i] = nums2[j];
    }

    Arrays.sort(nums1);
  }

  public static void main(String[] args) {
    MergedSortedArray msa = new MergedSortedArray();
    int[] nums1 = {1,2,3,0,0,0};
    int m = 3;
    int[] nums2 = {2,5,6};
    int n = 3;
    msa.merge(nums1, m, nums2, n);
    System.out.println("Result:");  
    for(int i: nums1) {
      System.out.println(i);
    }
  }
}
