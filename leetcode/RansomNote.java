public class RansomNote {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] letter  = new int[26];
    if(ransomNote.length() > magazine.length()) {
      return false;
    }

    for(int i=0;i<ransomNote.length();i++) {
      letter[ransomNote.charAt(i) - 'a']++;
    }

    for(int i=0;i<magazine.length();i++) {
      letter[magazine.charAt(i) - 'a']--;
    }

    
  
  }
}
