package viblo;

public class Redistribution {

  public static int countResults(int[] A) {
    int N = A.length;
    int sum = 0;
    for (int a : A) {
        sum += a;
    }

    // Tạo mảng động dp[N+1][sum+1]
    int[][] dp = new int[N + 1][sum + 1];
    dp[0][0] = 1; // Cơ sở cho trường hợp không có đĩa nào và túi không chứa đá

    // Tính toán số cách khác nhau
    for (int i = 1; i <= N; i++) {
        for (int j = 0; j <= sum; j++) {
            dp[i][j] = dp[i - 1][j]; // Chơi cách 1: không lấy đá từ đĩa thứ i
            if (j >= A[i - 1]) {
                dp[i][j] += dp[i - 1][j - A[i - 1]]; // Chơi cách 2: lấy đá từ đĩa thứ i
            }
        }
    }

    // Kết quả là tổng số cách đạt được khi không còn đĩa nào và túi không chứa đá
    return dp[N][0];
}

public static void main(String[] args) {
    int[] A = {3, 1, 3};
    System.out.println();
    System.out.println(countResults(A));
}
}
