import java.util.Arrays;

public class CoinChange {
  // public int coinChange(int[] coins, int amount) {
  //   if(amount == 0) {
  //     return 0;
  //   }

  //   int i = coins.length - 1;
  //   int total = 0;
  //   Arrays.sort(coins);

  //   while(amount!=0 && i !=-1) {
  //     int k = amount / coins[i];
  //     amount -=k*coins[i];
  //     total +=k;
  //     i--;
  //   }

  //   if(amount != 0) {
  //     return -1;
  //   }

  //   return total;
  // } 

  public static int result = Integer.MAX_VALUE;

  public int coinChange(int[] coins, int amount) {
    boolean[] visited= new boolean[coins.length+1];
    for(int i=0;i<visited.length;i++) {
      visited[i] = false;
    }
    
    findCombination(coins, amount, visited, 0 );

    if(result == Integer.MAX_VALUE) {
      return -1;
    }

    return result;
  }

  public void findCombination(int[] coins, int amount, boolean[] visited, int total) {
    if(amount == 0) {
       result = Math.min(total, result);
    }

    for(int i=0;i<coins.length;i++) {
      if(visited[i] == false) {
        int k = amount / coins[i];
        amount -= k*coins[i];
        total+=k;
        visited[i] = true;
        findCombination(coins, amount, visited, total);
        visited[i] = false;
        total-=k;
        amount += k*coins[i];
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(new CoinChange().coinChange(new int[]{1,2,5}, 11));
    // System.out.println(new CoinChange().coinChange(new int[]{2}, 3));
    // System.out.println(new CoinChange().coinChange(new int[]{1}, 0));
  }
}
