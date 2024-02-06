interface MyInterface {
  int myVariable = 10; // Biến hằng (static và final) mặc định
  void myMethod(); // Phương thức trừu tượng

  default void defaultMethod() {
      System.out.println("Default method in interface " + myVariable);
  }
}

class MyClass implements MyInterface {
  @Override
  public void myMethod() {
      System.out.println("Implemented abstract method");
  }
}

public class InterfaceHasVariable {
  public static void main(String[] args) {
      System.out.println(MyInterface.myVariable); // Truy cập biến hằng
      MyInterface myObject = new MyClass();
      myObject.myMethod(); // Gọi phương thức đã triển khai
      myObject.defaultMethod(); // Gọi phương thức mặc định
  }
}