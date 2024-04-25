import java.util.concurrent.Semaphore;
// class Foo {

//   private boolean oneDone;
//   private boolean twoDone;
//   public Foo() {
//       oneDone = false;
//       twoDone = false;
//   }

//   public synchronized void first(Runnable printFirst) throws InterruptedException {
//       printFirst.run();
//       oneDone = true;
//       notifyAll();
//   }

//   public synchronized void second(Runnable printSecond) throws InterruptedException {
      
//       while(!oneDone) {
//         wait();
//       }

//       printSecond.run();
//       twoDone = true;
//       notifyAll();
//   }

//   public synchronized void third(Runnable printThird) throws InterruptedException {
      
//       while(!twoDone) {
//         wait();
//       }

//       printThird.run();
      
// }
// }
// class Foo {

//   private boolean oneDone;
//   private boolean twoDone;
//   private Object lock;
//   public Foo() {
//     lock = new Object();
//       oneDone = false;
//       twoDone = false;
//   }

//   public void first(Runnable printFirst) throws InterruptedException {
//       synchronized(lock) {
//         printFirst.run();
//         oneDone = true;
//         lock.notifyAll();
//       }
//   }

//   public void second(Runnable printSecond) throws InterruptedException {
      
//     synchronized (lock) {
//       while (!oneDone) {
//           lock.wait();
//       }
//       printSecond.run();
//       twoDone = true;
//       lock.notifyAll();
//   }
//   }

//   public void third(Runnable printThird) throws InterruptedException {
      
//     synchronized (lock) {
//       while (!twoDone) {
//           lock.wait();
//       }
//       printThird.run();
//   }
      
// }
// }
// C3:
// class Foo {
//   private Object lock1;
//   private Object lock2;
//   private boolean oneDone;
//   private boolean twoDone;
  
//   public Foo() {
//       lock1 = new Object();
//       lock2 = new Object();
//       oneDone = false;
//       twoDone = false;
//   }

//   public void first(Runnable printFirst) throws InterruptedException {
//       synchronized (lock1) {
//           printFirst.run();
//           oneDone = true;
//           lock1.notifyAll();
//       }
//   }

//   public void second(Runnable printSecond) throws InterruptedException {
//       synchronized (lock1) {
//           synchronized (lock2) {
//               while (!oneDone) {
//                   lock1.wait();
//               }
//               printSecond.run();
//               twoDone = true;
//               lock2.notifyAll();
//           }
//       }
//   }

//   public void third(Runnable printThird) throws InterruptedException {
//       synchronized (lock2) {
//           while (!twoDone) {
//               lock2.wait();
//           }
//           printThird.run();
//       }
//   }
// }

// C4: using semaphone
class Foo {
  private Semaphore s2;
  private Semaphore s3;

  public Foo() {
    s2 = new Semaphore(0);
    s3 = new Semaphore(0);
  }

  public void first(Runnable printFirst) throws InterruptedException {
    printFirst.run();
    s2.release();
  }

  public void second(Runnable printSecond) throws InterruptedException {
    s2.acquire();
    printSecond.run();
    s3.release();
  }

  public void third(Runnable printThird) throws InterruptedException {
    s3.acquire();
    printThird.run();
  } 
}
public class PrintInOrder
{

  public static void main(String[] args) {
    Foo foo = new Foo();
    Runnable printFirst = new Runnable() {
      @Override
      public void run() {
        System.out.println("first");
      }
    };
    Runnable printSecond = new Runnable() {
      @Override
      public void run() {
        System.out.println("second");
      }
    };
    Runnable printThird = new Runnable() {
      @Override
      public void run() {
        System.out.println("third");
      }
    };
    try {
      foo.first(printFirst);
      foo.second(printSecond);
      foo.third(printThird);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}