package java;
public class CountCompleteDayPairs {
  public int countCompleteDayPairs(int[] hours) {
    int count = 0;
    for(int i=0; i< hours.length -1 ; i++) {
      for(int j=i+1; j< hours.length;j++) {
        if(((hours[i]%24) + (hours[j]%24)) % 24 == 0) {
          count++;
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    CountCompleteDayPairs countCompleteDayPairs = new CountCompleteDayPairs();
    int[] hours = {12,12,30,24,24};
    System.out.println();
    System.out.println(countCompleteDayPairs.countCompleteDayPairs(hours));
  }
}