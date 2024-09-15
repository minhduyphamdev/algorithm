package java;
public class IntegerReplacement {
  public int integerReplacement(int n) {
    int c = 0;
    while (n != 1) {
     if((n & 1) == 0 ) {
      n = n >>1;
     }
     else if(n==3 || ((n >> 1) & 1) ==0) {
      n--;
     }
     else {
      n++;
     }
     c++;
    }
    return c;
}

  public static void main(String[] args) {
    IntegerReplacement obj = new IntegerReplacement();
    System.out.println(obj.integerReplacement(8)); // 3
  }
}
