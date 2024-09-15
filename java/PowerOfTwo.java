package java;
public class PowerOfTwo {
  // public boolean isPowerOfTwo(int n) {
  //     if(n==1) {
  //         return true;
  //     }

  //     return n > 0 && n % 2 ==0 ? isPowerOfTwo(n/2) : false;
  // }

  public boolean isPowerOfTwo(int n) {
    return n > 0 && Integer.bitCount(n) == 1;
  }
  
  public static void main(String[] args) {
      PowerOfTwo obj = new PowerOfTwo();
      System.out.println(obj.isPowerOfTwo(16));
  }
}
