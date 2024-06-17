import java.util.*;

public class MedianFinder {
  // using List
  List<Integer> res;
  public MedianFinder() {
    res = new ArrayList<>();
  }

  public void addNum(int num) {
    int l = 0, r = res.size()-1;
    while(l<=r) {
      int m = l + (r-l)/2;
      if(res.get(m) == num) {
        res.add(m,num);
        return;
      } else if(res.get(m) < num) {
        l= m + 1;
      } else {
        r = m - 1;
      }
    }

    res.add(l,num);
  }

  public double findMedian() {
    int size = res.size();
    if(size%2==0) {
      return (res.get(size/2-1) + res.get(size/2))/2.0;
    } else {
      return res.get(size/2);
    }
  }

  public static void main(String[] args) {
    MedianFinder obj = new MedianFinder();
    obj.addNum(6);

  }
}
