package java;
public class LogestCommonPrefix {
  //Solution1
  // public String longestCommonPrefix(String[] strs) {
  //   String longestStr = "";
  //   outerloop: for(int i=0;i<strs[0].length(); i++) {
  //     for(int j=1; j<strs.length ;j++ ) {
  //         if(strs[j].length() <= i || strs[0].charAt(i) != strs[j].charAt(i)) {
  //           break outerloop;
  //         }
        
  //     }
  //     longestStr = longestStr + strs[0].charAt(i);
  //   }

  //   return longestStr;
  // }

  //Solution2
  public String longestCommonPrefix(String[] strs) {
    String prefix = strs[0];
    for(int i=1; i<strs.length ;i++ ) {
      while(strs[i].indexOf(prefix) != 0) {
        prefix = prefix.substring(0,prefix.length()-1);
        if(prefix.length() == 0) {
          return "";
        }
      }
    }

    return prefix;
  }

  public static void main(String[] args) {
    String[] strs = {"flower","flew","flight"};
    // String[] strs = {"ab","a"};
    System.out.println(new LogestCommonPrefix().longestCommonPrefix(strs));
  }
}
