package java;
import java.util.*;

public class CourseSchedule {

  // dfs solution
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    // Create an array to contain all adjacent node in prerequisites
    List<Integer>[] graph = new ArrayList[numCourses]; 

    for(int i=0;i<numCourses;i++) {
      graph[i] = new ArrayList<>();
    }

    // fill an graph
    for(int[] prerequisite: prerequisites) {
      graph[prerequisite[0]].add(prerequisite[1]);
    }

    int[] visited = new int[numCourses];
    
    for(int i=0; i < numCourses; i++) {
      if(!findCycle(graph, visited, i)) {
        return false;
      } 
    }

    return true;
  }

  // 0 : not visited, 1: visiting, 2: visited
  public boolean findCycle(List<Integer>[] graph,int[] visited, int pos) {
    // check if node is visitng
    if(visited[pos] == 1) {
      return false;
    }

    if(visited[pos] == 2) {
      return true;
    }

    visited[pos] = 1;
    
    for(int num: graph[pos]) {
      if(!findCycle(graph, visited, num)) {
        return false;
      }
    }

    visited[pos] = 2;
    
    return true;
  }

  public static void main(String[] args) {
    CourseSchedule cs = new CourseSchedule();
    // int numCourses = 5;
    // int[][] prerequisites = { {1,4},{2,4},{3,1},{3,2}};
    // int numCourses = 2;
    // int[][] prerequisites = { {1,0},{0,1}};
    int numCourses = 3;
    int[][] prerequisites = { {1,0},{1,2},{0,1}};
    System.out.println(cs.canFinish(numCourses, prerequisites));
  }

}
