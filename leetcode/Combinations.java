import java.util.ArrayList;
import java.util.List;

public class Combinations {
   public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> temp = new ArrayList<>();
      boolean[] isValid = new boolean[n];
      generateCases(result, temp, isValid, n, k, 0);

      return result;
    }

    public void generateCases(List<List<Integer>> result, List<Integer> temp, boolean[] isValid, int n, int k, int pos) {
      if(pos == k) {
        result.add(new ArrayList<>(temp));
        return;
      }

      for(int i=1;i<=n;i++) {
        if(!isValid[i-1]) {
          temp.add(i);
          isValid[i-1] = true;
          generateCases(result, temp, isValid, n, k, pos+1);
          temp.remove(temp.size()-1);
          isValid[i-1]=false;
        }
        
      }
    }

    public static void main(String[] args) {
      new Combinations().combine(4, 2);
    }
}

