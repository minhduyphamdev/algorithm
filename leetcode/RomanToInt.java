import java.util.Map;
import java.util.HashMap;

public class RomanToInt {
  public int romanToInt(String s) {
    Map<Character,Integer> map = new HashMap<Character, Integer>();
    map.put('I',1);
    map.put('V',5);
    map.put('X',10);
    map.put('L',50);
    map.put('C',100);
    map.put('D',500);
    map.put('M',1000);
    if(s.length() ==1) {
      return map.get(s.charAt(0));
    }
    int result = 0;
    int prevValue = 0;
    int currValue = 0;
    for(int i=0;i<s.length();i++) {
      currValue = map.get(s.charAt(i));
      if(prevValue < currValue) {
        result  = result + currValue - 2*prevValue;
      }
      else {
        result += currValue;
      }
      prevValue = currValue;
    }

    return result;
  }

  public static void main(String[] args) {
    String s="IV";
    RomanToInt myClass = new RomanToInt();
    System.err.println(myClass.romanToInt(s));
  }
}