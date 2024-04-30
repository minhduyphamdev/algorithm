import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArrayTraversal {
    
    // Breadth-First Search (BFS) for 1D array traversal
    public static void bfs(int[] array) {
        if (array == null || array.length == 0)
            return;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[array.length];
        
        // Start BFS from the first element of the array
        queue.offer(0);
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println(array[current]); // Process the current element
            
            // Explore neighbors
            if (current - 1 >= 0 && !visited[current - 1]) {
                queue.offer(current - 1);
                visited[current - 1] = true;
            }
            if (current + 1 < array.length && !visited[current + 1]) {
                queue.offer(current + 1);
                visited[current + 1] = true;
            }
        }
    }
    
    // Depth-First Search (DFS) for 1D array traversal
    public static void dfs(int[] array) {
        if (array == null || array.length == 0)
            return;
        
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[array.length];
        
        // Start DFS from the first element of the array
        stack.push(0);
        visited[0] = true;
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.println(array[current]); // Process the current element
            
            // Explore neighbors
            if (current - 1 >= 0 && !visited[current - 1]) {
                stack.push(current - 1);
                visited[current - 1] = true;
            }
            if (current + 1 < array.length && !visited[current + 1]) {
                stack.push(current + 1);
                visited[current + 1] = true;
            }
        }
    }
    
    // Main method to test the implementations
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("BFS traversal:");
        bfs(array);
        
        System.out.println("\nDFS traversal:");
        dfs(array);
    }
}
