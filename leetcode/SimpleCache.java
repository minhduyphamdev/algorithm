import java.util.LinkedHashSet;
import java.util.Set;

public class SimpleCache<K> {
  private Set<K> cache;
  private int size;

  public SimpleCache(int size) {
    this.cache = new LinkedHashSet<>();
    this.size = size;
  }

  public void put(K key) {
    if(this.cache.size() == this.size) {
      this.cache.remove(this.cache.iterator().next());
    }
    this.cache.add(key);
  }

  public boolean contains(K key) {
    return this.cache.contains(key);
  }

  public void remove(K key) {
    this.cache.remove(key);
  }

  public void print() {
    for(K s: this.cache) {
      System.out.print(s + " ");
    }
  }

  public static void main(String[] args) {
    SimpleCache<String> cache = new SimpleCache<>(3);
    cache.put("A");
    cache.put("D");
    cache.put("D");
    cache.print();
  }
}
