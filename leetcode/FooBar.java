import java.util.concurrent.Semaphore;

class FooBarChild {
  private int n;
  Semaphore lockFoo, lockBar;

  public FooBarChild(int n) {
    this.n = n;
    lockFoo = new Semaphore(1);
    lockBar = new Semaphore(0);
  }

  public void foo(Runnable printFoo) throws InterruptedException {
    
    for (int i = 0; i < n; i++) {
      lockFoo.acquire();
      printFoo.run();
      lockBar.release();
    }
  }
  

  public void bar(Runnable printBar) throws InterruptedException {
      
      for (int i = 0; i < n; i++) {
        lockBar.acquire();
        printBar.run();
        lockFoo.release();
      }
  }
}

public class FooBar {
  public static void main(String[] args) {
    FooBarChild fooBar = new FooBarChild(10);
    Runnable printFoo = new Runnable() {
      public void run() {
        System.out.println("foo");
      }
    };
    Runnable printBar = new Runnable() {
      public void run() {
        System.out.println("bar");
      }
    };
    try {
      Thread fooThread = new Thread(() -> {
        try {
            fooBar.foo(printFoo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    Thread barThread = new Thread(() -> {
        try {
            fooBar.bar(printBar);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    fooThread.join();
    barThread.join();
  } catch (Exception ex) {
    System.out.println("Exception "+ex);
  }
}
}