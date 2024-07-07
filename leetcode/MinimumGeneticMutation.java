
import java.util.*;


public class MinimumGeneticMutation {
  public int minMutation(String startGene, String endGene, String[] bank) {
    
    // check if startGene equals endGene then return immediately 
    if(startGene.equals(endGene)) {
      return 0;
    }


    Queue<String> queue = new LinkedList<>(); // list string are going to visit
    Set<String> geneStrings = new HashSet<>(); // list string already visited
    Set<String> bankSet = new HashSet<>(); // list of string in bank

    // add all string in bank to bankSet to use the contains method :v
    for(String gene : bank) {
      bankSet.add(gene);
    }

    // if bank not contains endGene then return -1
    if(!bankSet.contains(endGene)) {
      return -1;
    }

    char[] charSet = new char[]{'A','C','G','T'};

    // we add startGene to queue and geneStrings because we already visited it
    queue.add(startGene);
    geneStrings.add(startGene);

    int count = 0 ;

    while(!queue.isEmpty()) {
      int size  = queue.size();
      count++;
      while(size-- > 0 ) {
        String currentStr = queue.poll();
        char[] currArray = currentStr.toCharArray();

       // we loop through the current string and change each character to the other character
       for(int i=0;i<currArray.length;i++) {
        char oldChr = currArray[i];

        // we loop through the charSet and change the character at index i to the new character
        for(int j=0; j< charSet.length;j++) {
          if(charSet[j] == oldChr) {
            continue;
          }

          currArray[i] = charSet[j];
          String newStr = new String(currArray);
          if(newStr.equals(endGene)) {
            return count;
          }

          // if the new string is not in geneStrings and it is in bankSet then we add it to queue and geneStrings
          if(!geneStrings.contains(newStr) && bankSet.contains(newStr)) {
            queue.add(newStr);
            geneStrings.add(newStr);
          }

        }

        currArray[i] = oldChr;
       }
      }
      
    }

    // if we can't find the endGene then return -1
    return -1;
  }

  public static void main(String[] args) {
    MinimumGeneticMutation mgm = new MinimumGeneticMutation();
    String startGene = "AACCGGTT";
    String endGene = "AACCGGTA";
    String[] bank = new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"};
    System.out.println(mgm.minMutation(startGene, endGene, bank));
  }

}

 