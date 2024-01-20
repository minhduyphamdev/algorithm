import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/text-justification/?envType=study-plan-v2&envId=top-interview-150
public class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        List<String> currString = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        int currSum = 0;
        for(int i=0;i<words.length;i++)
        {
            if(currSum + words[i].length() + currString.size() > maxWidth) {
               justifyText(result, currString, currSum, maxWidth);
               currSum = 0;
               currString.clear();
            }

            currSum += words[i].length();
            currString.add(words[i]);
           
        }

        if(currSum !=0) {
          leftJustifyText(result, currString, currSum, maxWidth);
        }
    
    return result;
    }
    public void leftJustifyText(List<String> result, List<String> currString, int currSum, int maxWidth) {
      int len = currString.size();
 
      if(len==1) {
        result.add(currString.get(0) + " ".repeat(maxWidth-currString.get(0).length()));
        return ;
      }

      StringBuilder builder = new StringBuilder(currString.get(0));
      for(int i = 1; i < len; i++) {
        builder.append(" ").append(currString.get(i));
      }
      builder.append(" ".repeat(maxWidth-currSum - currString.size() + 1));

      result.add(builder.toString());
    }

    public void justifyText(List<String> result, List<String> currString, int currSum, int maxWidth) {
     
      int len = currString.size();
 
      if(len==1) {
        result.add(currString.get(0) + " ".repeat(maxWidth-currString.get(0).length()));
        return ;
      }

      int baseSpace = (maxWidth-currSum)/ (len-1);
      int extraSpace = (maxWidth - currSum) % (len - 1);
      StringBuilder builder = new StringBuilder(currString.get(0));
      for(int i = 1; i < len; i++) {
        int totalSpace = baseSpace+ (i<= extraSpace ? 1 : 0);
        builder.append(" ".repeat(totalSpace)).append(currString.get(i));
      }

      result.add(builder.toString());
    }

    public static void main(String[] args) {
        // String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        FullJustify fullJustify = new FullJustify();
        List<String> result = fullJustify.fullJustify(words, 16);
        for(String str : result) {
          System.out.println(str);
        }
    }
}
