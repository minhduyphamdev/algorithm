package java;
public class LabelStatement {
  public static void main(String[] args) {
    outerloop: for(int i=0;i<3;i++) {
      for(int j=0;j<3;j++) {
        assert i < 3 : "i = 2";
        // if(i==2) {
        //   break outerloop;
        // }
        System.out.print(j + " ");
    
      System.out.println();
    }
  
    }
  }
}
