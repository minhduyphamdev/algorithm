public class MultiplyStrings {
  public String multiply(String num1, String num2) {
    int n1 = num1.length(), n2 = num2.length();
    int[] graph = new int[n1+n2];
    for(int i=n1-1;i>=0;i--) {
      for(int j=n2-1;j>=0;j--) {
        graph[i+j+1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
      }
    }

    int carry = 0;
    for(int i = graph.length -1;i>=0;i--) {
      int tmp = (graph[i] + carry) % 10;
      carry = (graph[i] + carry) / 10;
      graph[i] = tmp;
    }

    StringBuilder sb = new StringBuilder();
    for (int num : graph) sb.append(num);
    while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
    return sb.length() == 0 ? "0" : sb.toString();
}

  public static void main(String[] args) {
    MultiplyStrings ms = new MultiplyStrings();
    System.out.println(ms.multiply("123","456"));
  }
}
