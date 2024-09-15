package java;
public class AlternatingGroupsII {
  public static int countAlternatingGroups(int[] colors, int k) {
    int n = colors.length;
    if (k > n) {
        return 0;
    }

    int count = 0;

    for (int start = 0; start < n; start++) {
        if (isAlternating(colors, start, k, n)) {
            count++;
        }
    }

    return count;
  }

private static boolean isAlternating(int[] colors, int start, int k, int n) {
    for (int i = 0; i < k; i++) {
        int currentIndex = (start + i) % n;
        int nextIndex = (start + i + 1) % n;
        if (colors[currentIndex] == colors[nextIndex]) {
            return false;
        }
    }
    return true;
}

public static void main(String[] args) {
    int[] colors = {0, 1, 0, 1, 1, 0, 1, 0};
    int k = 4;
    System.out.println(countAlternatingGroups(colors, k));  // Output: The number of alternating groups of length k
}
}
