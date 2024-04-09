public class MinMoney {
  private static int minSplitMoney = Integer.MAX_VALUE;

  public void leastMoney(int money, int[] moneyKind) {
    // temp là số tờ tiền có thể chia
    // pos vị trí hiện tại của mệnh giá tiền (moneyKind)
    findCombinations(money, moneyKind, 0,0);
  }

  public void findCombinations(int money,int[] moneyKind, int temp, int pos) {
    if(money == 0) {
        minSplitMoney = Math.min(minSplitMoney, temp);
        return;
    }

    for(int i=pos;i<moneyKind.length;i++) {
      if(money >= moneyKind[i]) {
        int divide = money / moneyKind[i];
        temp += divide;
        findCombinations(money - divide*moneyKind[i], moneyKind, temp, pos+1);
        temp -= divide;
      }
    } 
  }

  public static void main(String[] args) {
    MinMoney mm = new MinMoney();
    int[] moneyKind = new int[] {5,3,2};
    mm.leastMoney(6, moneyKind);
    System.out.println(minSplitMoney);
  }
}
