package others;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable{

  private ReentrantLock lock;
  private String name;

  Worker(ReentrantLock lock, String name) {
    this.lock = lock;
    this.name = name;
  }

  public static String getCurrentTime() {
    Date d = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
    return ft.format(d);
  }

  @Override
  public void run() {
    boolean isDoing = true;
    while(isDoing) {
      boolean status = lock.tryLock();

      if(status) {
        System.out.println(getCurrentTime() + ": task name - "+ name
                                + " outer lock acquired at "
                                + " Doing outer work");

        try {
          Thread.sleep(1500);
          lock.lock();
                try{
                    System.out.println(getCurrentTime() + ": task name - "+ name
                            + " inner lock acquired at "
                            + " Doing inner work");
                    System.out.println("Lock Hold Count - "+ lock.getHoldCount());
                    Thread.sleep(1500);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                  //Inner lock release
                  System.out.println(getCurrentTime() +  ": task name - " + name +
                  " releasing inner lock");
                  lock.unlock();
                }
                  System.out.println("Lock Hold Count - " + lock.getHoldCount());
                  System.out.println(getCurrentTime() + ": task name - " + name + " work done");

                  isDoing = false;
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
              //Outer lock release
              System.out.println(getCurrentTime()+ ": task name - " + name +
              " releasing outer lock");

              lock.unlock();
              System.out.println(getCurrentTime() + ": Lock Hold Count - ");
        }
      } else {
        System.out.println(getCurrentTime() + ": task name - " + name +
                            " waiting for lock " + lock.getHoldCount());
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
  
}

public class DemoReentrantLock {
    private static final Integer MAX = 4;
    public void demo()  {
      ReentrantLock reentrantLock = new ReentrantLock();
      Worker worker1 = new Worker(reentrantLock, "worker1");
      Worker worker2 = new Worker(reentrantLock, "worker2");
      Worker worker3 = new Worker(reentrantLock, "worker3");
      Worker worker4 = new Worker(reentrantLock, "worker4");
      ExecutorService pool = Executors.newFixedThreadPool(MAX);
      pool.execute(worker1);
      pool.execute(worker2);
      pool.execute(worker3);
      pool.execute(worker4);
      pool.shutdown();
    }

    public static void main(String[] args) {
      new DemoReentrantLock().demo();
    }

    
}

