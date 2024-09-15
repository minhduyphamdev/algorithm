package java;
public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int maxArea = height[left] * height[right];
    while(left< right) {
      if(height[left] < height[right]) {
        left++;
        maxArea = Math.max(maxArea, height[left] * (right - left));
      }
      else {
        right--;
        maxArea = Math.max(maxArea, height[right] * (right - left));
      }
    }

    return 
  }
}
