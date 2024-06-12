import java.util.ArrayList;
import java.util.List;

public class ConcatenatedStrings {

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "5", "6"};
        List<String> concatenatedStrings = generateConcatenatedStrings(arr);

        // Print the resulting concatenated strings
        for (String s : concatenatedStrings) {
            System.out.println(s);
        }
    }

    public static List<String> generateConcatenatedStrings(String[] arr) {
        List<String> result = new ArrayList<>();
        permute(arr, 0, result);
        return result;
    }

    public static void permute(String[] arr, int pos, List<String> result) {
      if(pos == arr.length-1) {
        StringBuilder sb = new StringBuilder();
        for(String s: arr) {
          sb.append(s);
        }

        result.add(sb.toString());

        return;
      } 

      for(int i=pos;i<arr.length;i++) {
        swap(arr, pos, i);

        permute(arr, pos+1, result);

        swap(arr,pos,i);
      }
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
