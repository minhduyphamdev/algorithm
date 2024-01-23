interface Test12 { 
  void show();
}

class Test1 implements Test12 {
  @Override
  public void show() {
    System.out.println("Test1");
  }
}

class Test2 implements Test12 {
  @Override
  public void show() {
    System.out.println("Test2");
  }
}

public class Test {
  public static void main(String[] args) {
    Test12 test1 = new Test12();
  }
}



