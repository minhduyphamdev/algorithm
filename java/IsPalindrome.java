package java;
public class IsPalindrome {
  public boolean isPalindrome(int x) {
    if (x < 0) {
        return false;
    }

    int reverse = 0;
    int old = x;
    while(x > 0) {
        reverse = reverse*10 + x%10;
        x = x/10;
    }

    return reverse == old;
 }

 public static void main(String[] args) {
   IsPalindrome ip = new IsPalindrome();
   System.out.println(ip.isPalindrome(121));
 }
}
