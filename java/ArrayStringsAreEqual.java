package java;
import java.util.*;

public class ArrayStringsAreEqual {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
      return String.join("",word1).equals(String.join("",word2));
    }

  public static void main(String[] args) {
    ArrayStringsAreEqual obj = new ArrayStringsAreEqual();
    String[] word1 = {"ab", "c"};
    String[] word2 = {"a", "bc"};
    System.out.println(obj.arrayStringsAreEqual(word1, word2)); // true
  }
}
