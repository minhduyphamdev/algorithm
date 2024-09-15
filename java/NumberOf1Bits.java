package java;
public class NumberOf1Bits {
  public int hammingWeight(int n) {
    int count = 0;
    while(n!=0) {
      count += (n&1) == 1 ? 1 : 0;
      n >>= 1;
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(new NumberOf1Bits().hammingWeight(2147483645));
  }
}
