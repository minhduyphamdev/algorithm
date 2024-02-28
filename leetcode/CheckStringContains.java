public class CheckStringContains {
  public boolean isContain(String x, String y) {
    if(x.length() < y.length()) {
      return false;
    }
    if(y.length()==0) {
      return true;
    }
    int count = 0;
    for(int i=0; i<x.length();i++) {
      if(x.charAt(i) == y.charAt(count)) {
        count++;

        if(count == y.length()) {
          return true;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    CheckStringContains csc = new CheckStringContains();
    System.out.println(csc.isContain("", ""));
  }
}
