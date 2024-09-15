package java;
public class FindSubString {
  public boolean solution(String x, String y) {
    if(y == null) {
      return true;
    }

    if(x==null) {
      return false;
    }
    
    if(y.length() > x.length()) {
      return false;
    }

    if(y.length() == 0) {
      return true;
    }
    
    int yPos = 0;
    int xPos = x.indexOf(y.charAt(yPos));
    if(xPos == -1) {
      return false;
    }

    while(xPos < x.length() && yPos < y.length()) {
      if(x.charAt(xPos) == y.charAt(yPos)) {
        yPos++;
      }

      xPos++;
    }

    return yPos == y.length();
  }

  public static void main(String[] args) {
    FindSubString findSubString = new FindSubString();
    String x = "ABCCBCZBCC";
    String y = "ZC";
    System.out.println(findSubString.solution(x, y));
  }
}
