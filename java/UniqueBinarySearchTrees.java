package java;
public class UniqueBinarySearchTrees {
  // g is how many unique BSTs can be formed with n nodes
  // f(i, n) is how many unique BSTs can be formed with i nodes as root
  public int numTrees(int n) {
    int[] g = new int[n+1];
    g[0] = 1;
    g[1] = 1;


    for(int i=2;i<=n;i++) {
      for(int j=1;j<=i;j++) {
        g[i] += g[j-1]*g[i-j];
      }
    }

    return g[n];
  }

  public static void main(String[] args) {
    UniqueBinarySearchTrees obj = new UniqueBinarySearchTrees();
    System.out.println(obj.numTrees(3)); 
  }
}
