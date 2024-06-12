public class BitwiseAndOfARange {
  // public int rangeBitwiseAnd(int left, int right) {
  //   while (right > left) right &= right - 1;
  //   return right;
  // }

  public int rangeBitwiseAnd(int m, int n) {
    if(m == 0){
        return 0;
    }
    int moveFactor = 1;
    while(m != n){
        m >>= 1;
        n >>= 1;
        moveFactor <<= 1;
    }
    return m * moveFactor;
  }

  public static void main(String[] args) {
    BitwiseAndOfARange bar = new BitwiseAndOfARange();
    System.out.println(bar.rangeBitwiseAnd(12,15));
    // System.out.println(4&3);
  }
}