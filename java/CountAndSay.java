package java;
public class CountAndSay {
  public String countAndSay (int n) {
    if (n == 1) {
      return "1";
    }
    
    String previousStr = countAndSay(n-1);
    StringBuilder result = new StringBuilder();
    int count = 1;
    for(int i=1;i<previousStr.length();i++) {
      if(previousStr.charAt(i) == previousStr.charAt(i-1)) {
        count ++;
      }
      else {
        result.append(count).append(previousStr.charAt(i-1));
        count = 1;
      }
    }

    result.append(count).append(previousStr.charAt(previousStr.length()-1));

    return result.toString();
  }


  public static void main(String[] args) {
    CountAndSay sayClass = new CountAndSay();
    System.out.println(sayClass.countAndSay(4));
  }
}
