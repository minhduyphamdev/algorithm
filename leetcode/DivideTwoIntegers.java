public class DivideTwoIntegers {
  // public int divide(int divident, int divisor) {
  //   if( divisor == 0 ) {
  //     throw new ArithmeticException("Cannot divide zero");
  //   }

  //   int sign = (divident >0) ^ (divisor > 0) ? -1 : 1;
  //   long posDivident = Math.abs((long)divident);
  //   long posDivisor = Math.abs((long)divisor);

  //   long count =0;
  //   while(posDivident>=posDivisor) {
  //     posDivident-=posDivisor;
  //     count++;
  //   }

  //   if(count>Integer.MAX_VALUE && sign == 1) {
  //     return Integer.MAX_VALUE;
  //   }

  //   return (int)count* sign;
  // }

  //time optimize solution
  public int divide(int dividend, int divisor) {
    if (divisor == 0) {
        throw new ArithmeticException("Cannot divide by zero");
    }

    if (dividend == Integer.MIN_VALUE && divisor == -1) {
        return Integer.MAX_VALUE;
    }

    int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;

    long posDividend = Math.abs((long) dividend);
    long posDivisor = Math.abs((long) divisor);

    int quotient = 0;

    while(posDividend>=posDivisor) {
      int multiple = 1;
      long tempDivisor = posDivisor;
      while(posDividend >= (tempDivisor << 1)) {
        tempDivisor <<= 1;
        multiple <<= 1;
      }

      posDividend -= tempDivisor;
      quotient += multiple;
    }

    return quotient * sign;
    
}

  public static void main(String[] args) {
    System.out.println(new DivideTwoIntegers().divide(15
    ,3));
  }
}
