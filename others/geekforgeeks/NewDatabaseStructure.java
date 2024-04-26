package geekforgeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/
// insert, update, delete in O(1) time no duplicate
public class NewDatabaseStructure {
      List<Integer> arr = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    public void insert(int x)
    {
       if(!map.containsKey(x)) {
            arr.add(x);
            map.put(x, arr.size()-1);
       }
    }

    public void remove(int x)
    {
       if(map.containsKey(x)) {
        int index = map.get(x);
        map.remove(x);
        if(index!=arr.size() -1 ){
            Collections.swap(arr, index, arr.size()-1);
            map.put(arr.get(index), index);
        }

        arr.remove(arr.size()-1);
       }
    }

    public int search(int x)
    {
        return map.getOrDefault(x, -1);
    }

    public int getRandom()
    {
        Random rand = new Random();
        int randomIndex = rand.nextInt(arr.size());
        return arr.get(randomIndex);
    }


    public static void main(String[] args)
    {
        NewDatabaseStructure ds = new NewDatabaseStructure();
        ds.insert(10);
        ds.insert(20);
        ds.insert(30);
        ds.insert(40);
        ds.remove(20);
        ds.insert(50);
        System.out.println(ds.getRandom());
    }
}
