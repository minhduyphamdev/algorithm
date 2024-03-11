public class Test1 {
  public boolean solution(String S) {
    return !S.contains("ba");
  }
  public static void main(String[] args) {
    Test1 test1 = new Test1();
    System.out.println(test1.solution("abba"));
  }
}
