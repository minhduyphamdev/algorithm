import java.util.*;

public class FIndAllDuplicatesInArray {
   public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
          int index = Math.abs(nums[i]) - 1;
          if(nums[index] < 0) {
            result.add(index + 1);
          }
          else {
            nums[index] = -nums[index];
          }

        }

        return result;
    }

    public static void main(String[] args) {
      FIndAllDuplicatesInArray f = new FIndAllDuplicatesInArray();
      int[] nums = {4,3,2,7,8,2,3,1};
      System.out.println(f.findDuplicates(nums));
    }
}
