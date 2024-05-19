import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class MutualExclusion {
  private static AtomicInteger COUNTER = new AtomicInteger(0);
  private static Lock lock = new ReentrantLock();

  public static void main(String... args) throws InterruptedException {

    final Runnable increaseCounterFunc = () -> IntStream.range(0,100).forEach(MutualExclusion::increaseCounter);

    final var first = new Thread(increaseCounterFunc);
    final var second = new Thread(increaseCounterFunc);

    first.start();
    second.start();
    
    first.join();
    second.join();

    System.out.println("Expected " +COUNTER);
  }

  private static void increaseCounter(int i) {
    COUNTER.incrementAndGet();
  }
}