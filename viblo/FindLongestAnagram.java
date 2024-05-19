package viblo;

import java.util.*;

public class FindLongestAnagram {
  static String slurpStdin() {
    String input = "";
    Scanner scan = new Scanner(System.in);

    while (true) {
        input += scan.nextLine();
        if (scan.hasNextLine()) {
            input += "\n";
        } else {
            break;
        }
    }

    return input;
}
public static int countDeletionsForAnagram(String str1, String str2) {
int[] count1 = new int[26];
int[] count2 = new int[26];

for(char ch1: str1.toCharArray()) {
  count1[ch1-'a'] ++;
}

for(char ch2: str2.toCharArray()) {
  count2[ch2-'a']++;
}

int deletions = 0;
for(int i=0;i<26;i++) {
  deletions += Math.abs(count1[i] - count2[i]);
}

return deletions;
}

public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);      

    String str1 = scan.nextLine();

    String str2 = scan.nextLine();
    System.out.println(countDeletionsForAnagram(str1,str2));
}
  
}
