//problem: https://leetcode.com/problems/largest-rectangle-in-histogram/description/

public class LargestRectangleInHistogram {
  public int largestRectangleArea(int[] heights) {
    if(heights == null || heights.length == 0) {
      return 0;
    }

    int len = heights.length;
    int max = 0;

    int[] left = new int[len];
    int[] right = new int[len];
    left[0] = -1;
    right[len-1] = len;

    // find farthest left large than height[i]
    for(int i=1;i < len;i++) {
      int j = i-1;
      while(j>=0 && heights[j]>=heights[i]) {
        j = left[j];
      }

      left[i] = j;
    }

    for(int i=len-2;i>=0;i--) {
      int j=i+1;
      while(j<len&& heights[j]>=heights[i]) {
        j = right[j];
      }
      right[i] = j;
    }

    for(int i=0;i<len;i++) {
      max = Math.max(max,heights[i] * (right[i] - left[i] - 1));
    }

    return max;
  }

  public static void main(String[] args) {
    LargestRectangleInHistogram lrh = new LargestRectangleInHistogram();
    int[] heights = new int[]{2,1,5,6,2,3};
    // int[] heights = new int[]{2,4};
    System.out.println(lrh.largestRectangleArea(heights));
  }
}
