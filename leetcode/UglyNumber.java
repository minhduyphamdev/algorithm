public class UglyNumber {
  public boolean isUgly(int n) {
      if(n<=1) {
        return true;
      }
      while(n%2==0) {
         n /=2;
      } 

      while(n%3==0) {
        n/=3;
      }
      
      while(n%5==0) {
        n/=5;
      }

      return n==1;
  }

  public static void main(String[] args) {
    UglyNumber un = new UglyNumber();
    System.out.println(un.isUgly(6));
  }
}
