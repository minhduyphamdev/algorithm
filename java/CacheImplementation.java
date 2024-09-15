package java;
public class CacheImplementation {
  class Cache {};

  class DiskCache extends Cache {};

  class OptimizedDiskCache extends DiskCache {};

  public static void main(String[] args) {
    CacheImplementation cacheImplementation = new CacheImplementation();
    OptimizedDiskCache optimizedDiskCache = cacheImplementation.new OptimizedDiskCache();
    DiskCache diskCache = (DiskCache) optimizedDiskCache;

    DiskCache diskCache1 = cacheImplementation.new DiskCache();
    OptimizedDiskCache optimizedDiskCache1 = (OptimizedDiskCache) diskCache1;
  };
}
