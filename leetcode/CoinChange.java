import java.util.Arrays;

public class CoinChange {
  // recursion ( time limit exceeded)
  // public int coinChange(int[] coins, int amount) {
  //   int res = countNumOfCoins(coins, amount, 0);
  //   return res != Integer.MAX_VALUE ? res : -1;
  // }

  // public int countNumOfCoins(int[] coins, int amount, int sum) {
  //   if(amount == 0) {
  //     return sum;
  //   }

  //   if(amount < 0) {
  //     return Integer.MAX_VALUE;
  //   }

  //   int min = Integer.MAX_VALUE;
  //   for(int i=0;i<coins.length;i++) {
  //     min = Math.min(min, countNumOfCoins(coins, amount - coins[i], sum+1));
  //   }

  //   return min;
  // }


  // dynamic programming
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount+1];
    Arrays.fill(dp, -1);
    int res = recursion(coins, amount, dp);
    return res == Integer.MAX_VALUE ? -1 : res;
  }

  public int recursion(int[] coins, int amount, int[] dp) {
    if( amount == 0) 
      return 0;
    int res = Integer.MAX_VALUE;
    for(int i=0;i<coins.length; i++) {
      int temp = 0;  
      if(amount-coins[i] >= 0) {
            if(dp[amount-coins[i]] != -1 ) {
                temp = dp[amount-coins[i]];
            } 
            else {
               temp = recursion(coins, amount - coins[i], dp);
            }

            if(temp != Integer.MAX_VALUE) {
              res = Math.min(res, temp +1);
            }
        }
    }

    dp[amount] = res;

    return res;
  }
  public static void main(String[] args) {
    System.out.println();
    System.out.println(new CoinChange().coinChange(new int[]{1,2,5}, 11));
    // System.out.println(new CoinChange().coinChange(new int[]{186,419,83,408}, 6249));
  }
}
