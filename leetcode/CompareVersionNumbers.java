public class CompareVersionNumbers {

  public int compareVersion(String version1, String version2) {
    int len1 = version1.length();
    int len2 = version2.length();

    int i = 0;
    int j = 0;
    int sum1 = 0;
    int sum2 = 0;
    while(i<len1 || j < len2) {
      while(i<len1 && version1.charAt(i) != '.') {
        sum1 = sum1*10 + version1.charAt(i++) - '0';
      }
      while(j<len2 && version2.charAt(j) != '.') {
        sum2 = sum2*10 + version2.charAt(j++) - '0';
      }

      if(sum1 < sum2) {
        return -1;
      }  
      
      if(sum1>sum2) {
        return 1;
      }

      i++;
      j++;
      sum1 = 0;
      sum2 = 0;
    }

    return 0;
  }

  public static void main(String[] args) {
    CompareVersionNumbers cvn = new CompareVersionNumbers();
    System.out.println(cvn.compareVersion("1.1", "1.10"));
  }
}
