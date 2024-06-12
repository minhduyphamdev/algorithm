import java.util.*;

public class SubStringWithConcatenationOfAllWords {

  // time limit exceeded
  // public static Set<String> generateConcatenatedStrings(String[] arr) {
  //   Set<String> result = new HashSet<>();
  //   permute(arr, 0, result);
  //   return result;
  // }

  // public static void permute(String[] arr, int pos,Set<String> result) {
  //   if(pos == arr.length-1) {
  //     StringBuilder sb = new StringBuilder();
  //     for(String s: arr) {
  //       sb.append(s);
  //     }

  //     result.add(sb.toString());

  //     return;
  //   } 

  //   for(int i=pos;i<arr.length;i++) {
  //     swap(arr, pos, i);

  //     permute(arr, pos+1, result);

  //     swap(arr,pos,i);
  //   }
  // }

  // private static void swap(String[] arr, int i, int j) {
  //     String temp = arr[i];
  //     arr[i] = arr[j];
  //     arr[j] = temp;
  // }

  // public List<Integer> findSubstring(String s, String[] words) {
  //   Set<String> permunations = generateConcatenatedStrings(words);


  //   List<Integer> pos = new ArrayList<>();
  //   for(String permunation: permunations) {
  //     int index = s.indexOf(permunation);
  //     while(index!=-1) {
  //       if(!pos.contains(index)) {
  //         pos.add(index);
  //       }
  //       index = s.indexOf(permunation, index+1);
  //     }
  //   }
    
  //   return pos;
  // }

  public List<Integer> findSubstring(String s, String[] words) {
    if(s.length() == 0 || words.length == 0) {
      return new ArrayList<>();
    }
    List<Integer> res = new ArrayList<>();

    Map<String, Integer> appearance = new HashMap<>();
    for(String word: words) {
      appearance.put(word, appearance.getOrDefault(word, 0) + 1);
    }

    int num = words.length;
    int wordLen = words[0].length();

    for(int i=0;i < s.length() - num * wordLen + 1; i++) {
      String sub = s.substring(i, i + num*wordLen);
      if(isConcat(appearance, wordLen, sub)) {
        res.add(i);
      }
    }

    return res;
  }

  public boolean isConcat(Map<String,Integer> appearance, int wordLen, String sub ) {
    Map<String,Integer> exist = new HashMap<>();
    for(int i=0;i<sub.length();i+=wordLen) {
      String s = sub.substring(i, i + wordLen);
      exist.put(s, exist.getOrDefault(s, 0) + 1);
    }

    return exist.equals(appearance);
  }

  public static void main(String[] args) {
    SubStringWithConcatenationOfAllWords obj = new SubStringWithConcatenationOfAllWords();
    // String s = "barfoothefoobarman";
    // String[] words = {"foo","bar"};
    String s = "wordgoodgoodgoodbestword";
    String words[] = {"word","good","best","word"};
    List<Integer> pos = obj.findSubstring(s, words);
    for(int i=0; i<pos.size();i++) {
      System.out.println(pos.get(i));
    }
  }
}
