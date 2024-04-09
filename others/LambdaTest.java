import java.util.*;
import java.util.function.*;

public class LambdaTest {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // Using a lambda expression for filtering even numbers
    Predicate<Integer> isOdd = n -> n%2 !=0;

    Consumer<Integer> printNumber = System.out::println;

    numbers.stream().filter(isOdd).forEach(printNumber);
  }
}
