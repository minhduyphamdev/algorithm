package java;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

  static Map<Character,String> map = new HashMap<Character,String> (){{
    put('1',"");
    put('2',"abc");
    put('3',"def");
    put('4',"ghi");
    put('5',"jkl");
    put('6',"mno");
    put('7',"pqrs");
    put('8',"tuv");
    put('9',"wxyz");
  }};

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<String>();
    if(digits.isEmpty()) {
      return result;
    }

    StringBuilder builder = new StringBuilder();
    combineMultipleLetter(result, digits, 0, builder);
    
    return result;
  }

  public void combineMultipleLetter(List<String> result, String digits, int pos, StringBuilder builder) {
    if(pos == digits.length()) {
      result.add(builder.toString());
      return;
    }

    Character c = digits.charAt(pos);
    String letters = map.get(c);
    for(int i=0; i<letters.length(); i++) {
      builder.append(letters.charAt(i));
      combineMultipleLetter(result, digits, pos+1,builder);
      builder.deleteCharAt(builder.length()-1);
    }
  }


  public static void main(String[] args) {
    String digits = "234";
    List<String> result = new LetterCombinationsOfAPhoneNumber().letterCombinations(digits);
    for(String letter: result) {
      System.out.println(letter);
    }
  }

}
