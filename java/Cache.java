package java;
import java.lang.reflect.Field;

public class Cache {
  public static void main(String[] args) {
    try {
        Class cache = Integer.class.getDeclaredClasses()[0]; // (1)
        Field fieldCache = cache.getDeclaredField("cache"); // (2)
        fieldCache.setAccessible(true); // (3)
        Integer[] newCache = (Integer[]) fieldCache.get(cache); // (4)

        // (5)
        int idx0 = 128; // index của 0
        int idx1 = 129; // index của 1
        newCache[idx0] = newCache[idx1];

        Integer a = 0;
        Integer b = 1;

        System.out.println(a + b);
    }catch (NoSuchFieldException | IllegalAccessException ex ) {
        ex.printStackTrace();
    }
}
}