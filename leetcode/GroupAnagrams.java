import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  // public List<List<String>> groupAnagrams(String[] strs) {
  //   HashMap<String,Integer> map = new HashMap<>();
  //   List<List<String>> groups = new ArrayList<>();
  //   for(int i=0;i< strs.length; i++) {
  //     char[] chars = strs[i].toCharArray();
  //     Arrays.sort(chars);
  //     String sortedStr = new String(chars);
  //     if(!map.containsKey(sortedStr)) {
  //       List<String> newList = new ArrayList<>();
  //       newList.add(strs[i]);
  //       map.put(sortedStr, groups.size());
  //       groups.add(newList);
  //     }
  //     else {
  //       int pos = map.get(sortedStr);
  //       groups.get(pos).add(strs[i]);
  //     }
  //   }

  //   return groups;
  // }

  public String getSignature(String str) {
    char[] chs = str.toCharArray();
    Arrays.sort(chs);
    
    return new String(chs);
  }
 
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    Map<String,List<String>> map = new HashMap<>();

    for(String str: strs) {
      map.computeIfAbsent(getSignature(str), k -> new ArrayList<>()).add(str);
    }

    result.addAll(map.values());
    
    return result;
  }

    // public String getSignature(String s) {
    //     int[] count = new int[26];
    //     for (char c : s.toCharArray()) {
    //         count[c - 'a']++;
    //     }

    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < 26; i++) {
    //         if (count[i] != 0) {
    //             sb.append((char) ('a' + i)).append(count[i]);
    //         }
    //     }
    //     return sb.toString();
    // }

    // public List<List<String>> groupAnagrams(String[] strs) {
    //     List<List<String>> result = new ArrayList<>();
    //     Map<String, List<String>> groups = new HashMap<>();

    //     for (String s : strs) {
    //         groups.computeIfAbsent(getSignature(s), k -> new ArrayList<>()).add(s);
    //     }

    //     result.addAll(groups.values());

    //     return result;
    // }

  public static void main(String[] args) {
    String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
    new GroupAnagrams().groupAnagrams(strs);
  }
}
