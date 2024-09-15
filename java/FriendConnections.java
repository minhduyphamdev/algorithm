package java;
import java.util.*;

public class FriendConnections {
  public int friendConnections(String[] connections, String name1, String name2) {
    Map<String, List<String>> treeConnections = new HashMap<String, List<String>>();

    // put connections to tree
    for(int i=0;i<connections.length;i++) {
      String[] connection = connections[i].split(":");
      if(!treeConnections.containsKey(connection[0])) {
        treeConnections.put(connection[0], new ArrayList<>());
      }
      if(!treeConnections.containsKey(connection[1])) {
        treeConnections.put(connection[1], new ArrayList<>());
      }
      treeConnections.get(connection[0]).add(connection[1]);
      treeConnections.get(connection[1]).add(connection[0]);
    }

    //using bfs with recursive
    Set<String> visited = new HashSet<>();
    List<Integer> distances = new ArrayList<>();
    visited.add(name1);
    
    findDegreeOfSeperation(treeConnections, name1, name2, visited,distances,0);

    if(distances.size() == 0) {
      return -1;
    }

    return Collections.min(distances);
  }

  public void findDegreeOfSeperation(Map<String, List<String>> treeConnections, String currPerson, String name2, Set<String> visited, List<Integer> distances, int degree) {
    if(currPerson.equals(name2)) {
      distances.add(degree);
      return;
    }

    List<String> connections = treeConnections.get(currPerson);
    for(String person: connections) {
      if(!visited.contains(person)) {
        visited.add(person);
        findDegreeOfSeperation(treeConnections, person, name2, visited, distances,degree+1);
        visited.remove(person);
      }
    }
  }

  public static void main(String[] args) {
    FriendConnections fc = new FriendConnections();
    String[] connections = new String[]{"fred:joe","joe:mary","mary:fred","mary:bill"};
    System.out.println(fc.friendConnections(connections, "fred", "sally"));
  }
}
