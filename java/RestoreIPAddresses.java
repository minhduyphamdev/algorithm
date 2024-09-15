package java;
import java.util.*;

public class RestoreIPAddresses {
  // index to show the currPosition, current is used for each element in string

  public List<String> restoreIpAddresses(String s) {
    List<String> ipAddresses = new ArrayList<>();
    generateIpAddress(ipAddresses, s, new ArrayList<>(),0);
    return ipAddresses;
  }

  public void generateIpAddress(List<String> ipAddresses, String s, List<String> temp, int index) {
    if(index == s.length() && temp.size() == 4) {
      ipAddresses.add(String.join(".",temp));
    }

    if(index > s.length() || temp.size() >=4) {
      return;
    }

    for(int i=1;i<=3 && index + i<=s.length();i++) {
      String segment = s.substring(index, index+i);
      if(isValidSegment(segment)) {
        temp.add(segment);
        generateIpAddress(ipAddresses, s, temp, index+i);
        temp.remove(temp.size()-1);
      }
    }
  }

  public boolean isValidSegment(String segment) {
    if(segment.length() > 1 && segment.charAt(0) == '0') {
        return false;
    }

    int segmentValue = Integer.valueOf(segment);
    return segmentValue >=0 && segmentValue <=255;
  }

  public static void main(String[] args) {
    RestoreIPAddresses ria = new RestoreIPAddresses();
    List<String> ipes = ria.restoreIpAddresses("25525511135");
    for (String ip : ipes) {
      System.out.println(ip);
    }
  }
}

