import java.util.*;

public class DegreesOfSeperations {
  public int solution(String[] connections, String name1, String name2) {
    if(connections == null || connections.length == 0) {
      return -1;
    }

    if(name1 == null || name2 == null) {
      return -1;
    }
    // store all connections 
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    // store all current friends of node
    Queue<String> queue = new LinkedList<>();
    // check if friend is go into queue all not  
    HashSet<String> isGoThrough = new HashSet<>();
    int count = 0, currSize = 0;
    for(String connection: connections) {
      String[] people = connection.split(":");
      map.computeIfAbsent(people[0], k -> new ArrayList<String>()).add(people[1]);
      map.computeIfAbsent(people[1], k -> new ArrayList<String>()).add(people[0]);
    }

    queue.add(name1);
    isGoThrough.add(name1);

    while(!queue.isEmpty()) {
      currSize = queue.size();
      while(currSize > 0) {
        String person = queue.poll();
        if(person.equals(name2)) {
          return count;
        }
  
        List<String> friends = map.get(person);
        for(String friend: friends) {
          if(!isGoThrough.contains(friend)) {
            queue.add(friend);
            isGoThrough.add(friend);
          }
        }
        currSize--;
      }
      count++;
    }

    return -1;
  }

  public static void main(String[] args) {
    String[] connections = new String[] {};
    String name1 = "fred";
    String name2 = "bill";
    
    DegreesOfSeperations obj = new DegreesOfSeperations();
    System.out.println(obj.solution(connections, name1, name2));
  }
}
