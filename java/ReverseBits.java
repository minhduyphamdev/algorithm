package java;
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
      int result = 0;
      
      for (int i = 0; i < 32; i++) {
          result <<= 1;
          result = result | (n & 1);
          n >>= 1;
      }
      
      return result;
  }

  public static void main(String[] args) {
    System.out.println(new ReverseBits().reverseBits(43261596));
  }
}
