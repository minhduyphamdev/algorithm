package java;
import java.util.*;

public class FractionToDecimal {
  public String fractionToDecimal(int numerator, int denominator) {
    if(numerator ==0) {
      return "0";
    }
    StringBuilder res = new StringBuilder();
    if((numerator < 0 && denominator >0) || (numerator > 0 && denominator < 0)) {
      res.append("-");
      if(numerator != Integer.MIN_VALUE) {
          numerator = - numerator;
      }
      else {
          denominator = -denominator;
      }
    }
    long num = (long) numerator;
    long den = (long) denominator;
   long quotient = num / den;
    long remainder = num % den;
    res.append(quotient);
    if(remainder == 0) {
      return res.toString();
    }

    res.append(".");
    Map<Long, Integer> map = new HashMap<>();
    while(remainder!=0) {
      if(map.containsKey(remainder)) {
        int pos = map.get(remainder);
        res.insert(pos,"(");
        res.append(")");
        break;
      }
      else {
        map.put(remainder, res.length());
        remainder *=10;
        quotient = (int)(remainder / den);
        remainder = remainder % den;
        res.append(quotient);
      }
    }

    return res.toString();
  }

  public static void main(String[] args) {
    FractionToDecimal fd = new FractionToDecimal();
    System.out.println(fd.fractionToDecimal(-2147483648,1));
  }
}
