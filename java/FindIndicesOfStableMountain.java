package java;
import java.util.ArrayList;
import java.util.List;

public class FindIndicesOfStableMountain {
  public List<Integer> stableMountains(int[] height, int threshold) {
    List<Integer> stables = new ArrayList<>();
    for (int i = 1; i < height.length; i++) {
      if (height[i - 1] > threshold) {
        stables.add(i);
      }
    }

    return stables;
  }

  public static void main(String[] args) {
    int[] height = { 1, 2, 3, 4, 5 };
    int threshold = 2;
    FindIndicesOfStableMountain findIndicesOfStableMountain = new FindIndicesOfStableMountain();
    List<Integer> stables = findIndicesOfStableMountain.stableMountains(height, threshold);
    for (int i = 0; i < stables.size(); i++) {
      System.out.println(stables.get(i));
    }
  }
}