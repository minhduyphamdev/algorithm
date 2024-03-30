public class AddDigits {
  public int addDigits(int num){
    if(num < 10) {
      return num;
    }
    return findOneDigit(Integer.toString(num));
  }

  public int findOneDigit(String num) {
    if(num.length() == 1) {
      return Integer.valueOf(num);
    }

    int sum =0;
    for(int i=0;i<num.length();i++) {
      sum+=num.charAt(i)-'0';
    }

    return findOneDigit(Integer.toString(sum));
  }

  public static void main(String[] args) {
    AddDigits ad = new AddDigits();
    System.out.println(ad.addDigits(38));
  }
}
