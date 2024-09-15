package java;
import java.util.*;

public class TopKFrequentElement {
  public int[] topKFrequent(int[] nums, int k) {
    // Creating a Frequency Table
    Map<Integer, Integer> map = new HashMap<>();
    for(int num: nums) {
      map.put(num, map.getOrDefault(num, 0)+1);
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
    pq.addAll(map.keySet());

    int[] res = new int[k];
    while(k>  0) {
      res[--k] = pq.poll();
    };

    return res;
}

    public static void main(String[] args) {
        TopKFrequentElement topKFrequentElement = new TopKFrequentElement();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] res = topKFrequentElement.topKFrequent(nums, k);
        for(int num: res) {
            System.out.print(num + " ");
        }

    }
}
