import java.util.Scanner;

public class RegularExpressionMatching {
  private boolean isMatch(String s, int sidx, String p, int pidx) {
    if(pidx >= p.length()) {
      return sidx == s.length();
    }

    if((pidx+1) < p.length() && p.charAt(pidx+1) == '*') {
      if(isMatch(s,sidx, p ,pidx +2)) {
        return true;
      }
      if(sidx < s.length() && (p.charAt(pidx) == '.' || p.charAt(pidx) == s.charAt(sidx))) {
        return isMatch(s, sidx+1,p, pidx);
      }
    } else if(sidx < s.length() && (p.charAt(pidx) == '.' || p.charAt(pidx) == s.charAt(sidx))) {
      return isMatch(s,sidx+1,p,pidx+1);
    }
 
    return false;
}

  public boolean isMatch(String s, String p) {
      return isMatch(s, 0, p, 0);
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s= scanner.nextLine();
    String p = scanner.nextLine();
    RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
    System.out.println(regularExpressionMatching.isMatch(s, p));
  }
}
