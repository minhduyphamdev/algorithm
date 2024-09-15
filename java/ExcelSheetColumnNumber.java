package java;
public class ExcelSheetColumnNumber {
  public int titleToNumber(String columnTitle) {
    int res = 0;
    int n = columnTitle.length();
    for(int i=0;i<n;i++) {
      res += (columnTitle.charAt(i) - 'A'+1)*Math.pow(26,n-i-1);
    }

    return res;
  }

  public static void main(String[] args) {
    System.out.println(new ExcelSheetColumnNumber().titleToNumber("AB"));
  }
}
