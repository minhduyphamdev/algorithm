public class MyPow {
  public double myPow(double x, int n) {
    if(n<0) {
        x = 1 / x;
        n = -n;
    }

    return pow(x,n);
  }

  public double pow(double x, int n) {
      if(n==0) {
          return 1;
      }
      double half = pow(x,n/2);
      if(n % 2 == 0 ) {
        return half * half;
      }
      
      return half*half*x;
  }

  public static void main(String[] args) {
    MyPow mp = new MyPow();
    System.out.println(mp.myPow(0.00001
    , 2147483647
    ));
  }
}
