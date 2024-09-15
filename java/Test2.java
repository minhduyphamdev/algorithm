package java;
public class Test2 {
  public int solution(String s) {
    if(s.length() == 1) {
      return 1;
    }
    // the status of previous player
    boolean isMove = true;
    int count = 0;
    for(int i=0;i<s.length();i++) {
      if(s.charAt(i) == '>'){
        if(i == s.length() -1){
          count++;
          break;
        }
        isMove = false;
      }
      else if(s.charAt(i) == '<') {
        if(isMove) {
          count++;
        }
      }
      else if(s.charAt(i) == '^') {
        if(!isMove)
        {
          isMove = true;
        }

        count ++;
      } else {
        if(!isMove) {
          isMove = true;
        }

        count ++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    Test2 test2 = new Test2();
    System.out.println(test2.solution("^"));
  }
}
