package java;
import java.util.*;

public class CourseScheduleII {
  List<Integer> res = new ArrayList<>();
  // dfs solution
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    // Create an array to contain all adjacent node in prerequisites
    List<List<Integer>> graph = new ArrayList<>();

    for(int i=0;i<numCourses;i++) {
      graph.add(new ArrayList<>());
    }

    // fill an graph
    for(int[] prerequisite: prerequisites) {
      graph.get(prerequisite[0]).add(prerequisite[1]);
    }

    int[] visited = new int[numCourses];
    
    for(int i=0; i < numCourses; i++) {
      if(!findCycle(graph, visited, i)) {
        return new int[] {};
      } 
    }

    return res.stream().mapToInt(i -> i).toArray();
  }

  // 0 : not visited, 1: visiting, 2: visited
  public boolean findCycle(List<List<Integer>> graph,int[] visited, int pos) {
    // check if node is visitng
    if(visited[pos] == 1) {
      return false;
    }

    if(visited[pos] == 2) {
      return true;
    }

    visited[pos] = 1;
    
    for(int num: graph.get(pos)) {
      if(!findCycle(graph, visited, num)) {
        return false;
      }
    }

    visited[pos] = 2;
    res.add(pos);
    
    return true;
  }

  public static void main(String[] args) {
    CourseScheduleII cs = new CourseScheduleII();
    // int numCourses = 5;
    // int[][] prerequisites = { {1,4},{2,4},{3,1},{3,2}};
    // int numCourses = 2;
    // int[][] prerequisites = { {1,0}};
    // int numCourses = 3;
    // int[][] prerequisites = { {1,0},{1,2},{0,1}};
    int numCourses = 1;
    int[][] prerequisites = {};
    int[] res = cs.findOrder(numCourses, prerequisites);
    System.out.println("Result:");  
    for(int i: res) {
      System.out.println(i);
    }
  }

}
