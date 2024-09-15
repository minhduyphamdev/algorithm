package java;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
  public static void main(String[] args) {
    LinkedHashMap<String,Integer> map = new LinkedHashMap<String,Integer>();
    map.put("key a",1);
    map.put("key b",2);
    for( Map.Entry<String,Integer> entry: map.entrySet()) {
      System.out.println(entry.getKey() + " "+ entry.getValue());
    }
  }
}
