
public class Test3 {
  // public boolean solution(int N, int[] A,int[] B) {
  //   int M = A.length;
  //   if(M == 0) {
  //     return false;
  //   }
  //   Boolean[][] dp = new Boolean[N+1][N+1];
  //   for(int i=0;i<M;i++) {
  //     dp[A[i]][B[i]] = true;
  //   }

  //   for(int i=1;i<N;i++) {
  //     if(dp[i][i+1] == null && dp[i+1][i] == null)
  //       return false;
  //   }

  //   return true;
  // }

    public boolean solution(int N, int[] A,int[] B) {
    int M = A.length;
    if(M == 0) {
      return false;
    }
    Boolean[] dp = new Boolean[N];
    for(int i=0;i<M;i++) {
      if(A[i] == B[i] +1 || B[i] == A[i] + 1) {
        dp[Math.min(A[i],B[i])] = true;
      }
    }

    for(int i=1;i<N;i++) {
      if(dp[i] == null) 
        return false;
    }

    return true;
  }

  public static void main(String[] args) {
    Test3 test3 = new Test3();
    // System.out.println(test3.solution(4, new int[]{1,2,4,4,3}, new int[]{2,3,1,3,1}));
    System.out.println(test3.solution(2, new int[]{2}, new int[]{2}));
  }
}
