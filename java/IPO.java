package java;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class IPO {
   // Defining the Project class within the Solution class
    class Project {
        int profit;
        int capital;

        Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Project> projects  = new ArrayList<>();

        for(int i=0; i< profits.length ;i++) {
            projects.add(new Project(profits[i], capital[i]));
        }

        Collections.sort(projects, (a,b) -> a.capital - b.capital);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int ele = 0;
        int max = w;

        for(int i = 0 ; i <k;i++) {
            while(ele < projects.size() && projects.get(ele).capital <= max) {
                maxHeap.add(projects.get(ele).profit);
                ele++;
            }
            
            if(maxHeap.isEmpty()) {
                return max;
            }

            max += maxHeap.poll();

        }

        return max;
    }

    public static void main(String[] args) {
        IPO ipo = new IPO();
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        System.out.println(ipo.findMaximizedCapital(2, 0, profits, capital));
    }
}
