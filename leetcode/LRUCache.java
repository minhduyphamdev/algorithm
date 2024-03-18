import java.util.*;



public class LRUCache {
  class DListNode {
    int key;
    int value;
    DListNode prev;
    DListNode post;

    public DListNode() {

    }
  
    public DListNode(int key, int value) {
        this.key = key;
        this.value = value;
        prev = null;
        post = null;
    }
  }
  HashMap<Integer, DListNode> cache;
  DListNode head;
  DListNode tail;
  int capacity;
  int size;

  public LRUCache(int capacity) {
    this.cache = new HashMap<>();
    this.head = new DListNode();
    this.tail = new DListNode();
    this.capacity = capacity;
    this.size = 0;
    head.post = tail;
    tail.prev = head;
  }

  public void insert(int key, int value) {
    DListNode newNode = new DListNode(key,value);
    newNode.post = head.post;
    head.post.prev = newNode;
    head.post = newNode;
    newNode.prev = head;
    cache.put(key,newNode);
    size ++;
  }
 
  public void removeLRNode() {
    DListNode LRNode = tail.prev;
    tail.prev.prev.post = tail;
    tail.prev = tail.prev.prev;
    cache.remove(LRNode.key);
    size--;
  }

  public void removeNode(DListNode node) {
    node.prev.post = node.post;
    node.post.prev = node.prev;
    cache.remove(node.key);
    size--;
  }

  public int get(int key) {
    if(size == 0) {
      return -1;
    }

    DListNode node = cache.get(key);
    if(node == null) {
      return -1;
    }

    removeNode(node);
    insert(key, node.value);

    return node.value;
  }

  public void put(int key, int value) {
    DListNode node = cache.get(key);

    if(node == null) {
      insert(key, value);
      if(size > capacity) {
        removeLRNode();
      }
    } else {
      removeNode(node);
      insert(key, value);
    }
  }


  public static void main(String[] args) {
    LRUCache lru = new LRUCache(2);
    lru.put(1, 1);
    lru.put(2, 2);
    System.out.println(lru.get(1));
    lru.put(3, 3);
    System.out.println(lru.get(2));
    lru.put(4, 4);
    System.out.println(lru.get(1));
    System.out.println(lru.get(3));
    System.out.println(lru.get(4));
  }
}