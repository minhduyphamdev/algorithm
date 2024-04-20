import java.util.*;

public class FindKPairsWithSmallestSum {
  public List<List<Integer>> kSmallestPairs (int[] nums1, int[] nums2, int k) {
    List<List<Integer>> res = new ArrayList<>();
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

    for(int num: nums1) {
      pq.add(new int[] {num+nums2[0], 0});
    }

    while(k>0) {
      int[] ele = pq.poll();
      int sum = ele[0];
      int pos = ele[1];

      res.add(new ArrayList<>(Arrays.asList(sum-nums2[pos], nums2[pos])));

      if(pos+1 < nums2.length) {
        pq.add(new int[] {sum - nums2[pos] + nums2[pos+1], pos+1});
      }

      k--;
    }

    return res;
  }

  public static void main(String[] args) {
    FindKPairsWithSmallestSum obj = new FindKPairsWithSmallestSum();
    int[] nums1 = {1, 7, 11};
    int[] nums2 = {2, 4, 6};
    int k = 3;
    List<List<Integer>> res = obj.kSmallestPairs(nums1, nums2, k);
    System.out.println(res);
  }
}
 