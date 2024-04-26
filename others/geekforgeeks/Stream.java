package geekforgeeks;

// Java program to design a data structure
// that supports insert, delete,
// getRandom in O(1) with duplicates
import java.util.*;

public class Stream {

	List<Integer> nums;
	Map<Integer, Set<Integer> > map;

	public Stream()
	{
		nums = new ArrayList<>();
		map = new HashMap<>();
	}

	public boolean insert(int val)
	{
		nums.add(val);
		if(!map.containsKey(val)) {
			map.put(val, new HashSet<>());
		}

		map.get(val).add(nums.size()-1);
		return map.get(val).size() == 1;
	}

	public boolean remove(int val)
	{
		if(!map.containsKey(val)) {
			return false;
		}

		Set<Integer> valIndices = map.get(val);
		int index = valIndices.iterator().next();
		int lastIndex = nums.size()-1;
		valIndices.remove(index);
		if(index!=lastIndex) {
			int lastNum = nums.get(lastIndex);
			map.get(lastNum).remove(lastIndex);
			map.get(lastNum).add(index);
			Collections.swap(nums, index, lastIndex);
		}

		nums.remove(nums.size()-1);
		return true;
	}

	public int getRandom() {
		int random = (int)(Math.random()*nums.size());
		return nums.get(random);
	}
	public static void main(String[] args)
	{
		Stream myStream = new Stream();
		System.out.println(myStream.insert(5));
		System.out.println(myStream.insert(6));
		System.out.println(myStream.insert(5));
		System.out.println(myStream.remove(5));
		System.out.println(myStream.remove(6));
		System.out.println(myStream.getRandom());
	}
}



