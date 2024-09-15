package java;
public class MaximumHeightOfATriangle {
  public static int maxHeightOfTriangle(int red, int blue) {
    // Calculate maximum height starting with red as odd row
    int heightOddRed = calculateMaxHeight(red, blue, true);

    // Calculate maximum height starting with red as even row
    int heightEvenRed = calculateMaxHeight(red, blue, false);

    // Return the maximum of the two heights
    return Math.max(heightOddRed, heightEvenRed);
}

private static int calculateMaxHeight(int red, int blue, boolean startWithRedOdd) {
    int row = 1;

    while (red >= row || blue >= row) {
        if(startWithRedOdd) {
          if(row%2 == 1 && red >= row) {
            red -=row;
          } else if (row%2 == 0 && blue >= row) {
            blue -=row;
          } else {
            break;
          }
        } else {
          if(row%2==1 && blue >= row) {
            blue -=row;
          } else if (row%2 == 0 && red >= row) {
            red -=row;
          } else {
            break;
          }
        }
        row++;
    }

    return row - 1;
}

  public static void main(String[] args) {
    MaximumHeightOfATriangle mhot = new MaximumHeightOfATriangle();
    System.out.println();
    System.out.println(mhot.maxHeightOfTriangle(2, 4));
    // System.out.println(mhot.maxHeightOfTriangle(2, 1));
    // System.out.println(mhot.maxHeightOfTriangle(3, 3));
  }
}
