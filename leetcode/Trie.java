import java.util.*;

class TrieNode {
  TrieNode[] children;
  boolean isEndOfWord;

  public TrieNode() {
      children = new TrieNode[26]; // Assuming lowercase English letters only
      isEndOfWord = false;
  }
}

public class Trie {
  private TrieNode root;

  public Trie() {
      root = new TrieNode();
  }

  public void insert(String word) {
      TrieNode current = root;
      for (char c : word.toCharArray()) {
          int index = c - 'a';
          if (current.children[index] == null) {
              current.children[index] = new TrieNode();
          }
          current = current.children[index];
      }
      current.isEndOfWord = true;
  }

  public boolean search(String word) {
      TrieNode current = root;
      for (char c : word.toCharArray()) {
          int index = c - 'a';
          if (current.children[index] == null) {
              return false;
          }
          current = current.children[index];
      }
      return current != null && current.isEndOfWord;
  }

  public boolean startsWith(String prefix) {
      TrieNode current = root;
      for (char c : prefix.toCharArray()) {
          int index = c - 'a';
          if (current.children[index] == null) {
              return false;
          }
          current = current.children[index];
      }
      return current != null;
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    System.out.println(trie.search("apple"));   // returns true
    System.out.println(trie.search("app"));     // returns false
    System.out.println(trie.startsWith("app")); // returns true
    trie.insert("app");
    System.out.println(trie.search("app"));     // returns true
  }
}

