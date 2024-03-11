import java.util.*;

public class ConvertToTitle {
  public String convertToTitle(int n) {
    StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
  };

  public static void main(String[] args) {
    ConvertToTitle convertToTitle = new ConvertToTitle();
    System.out.println(convertToTitle.convertToTitle(28));
  }
}
