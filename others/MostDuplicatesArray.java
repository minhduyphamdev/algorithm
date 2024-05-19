import java.util.*;

public class MostDuplicatesArray {

    public static int[][] mostDuplicates(int[][][] arrays) {
        int maxDuplicates = 0;
        int[][] maxArray = null;
        Map<Integer, Integer> frequency = new HashMap<>();

        // Count the frequency of each element
        for (int[][] array : arrays) {
            for (int[] pair : array) {
                int ai = pair[0];
                frequency.put(ai, frequency.getOrDefault(ai, 0) + 1);
            }
        }

        // Find the array with the most duplicates
        for (int[][] array : arrays) {
            int duplicates = 0;
            for (int[] pair : array) {
                int ai = pair[0];
                duplicates += frequency.get(ai);
            }
            if (duplicates > maxDuplicates) {
                maxDuplicates = duplicates;
                maxArray = array;
            }
        }

        return maxArray;
    }

    public static void main(String[] args) {
        int[][][] arrays = {
            {{1, 2}, {3, 4}},
            {{1, 5}, {6, 7}},
            {{1, 8}, {9, 10}}
        };

        int[][] result = mostDuplicates(arrays);
        System.out.println("Array with most duplicates:");
        for (int[] pair : result) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
