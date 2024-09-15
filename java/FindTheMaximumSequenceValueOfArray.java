package java;

public class FindTheMaximumSequenceValueOfArray {
    public int maxValue(int[] nums, int k) {
        int maxValue = 0;
        int n = nums.length;

        // Generate all combinations of indices for size 2 * k
        for (int i = 0; i < (1 << n); i++) {
            int count = Integer.bitCount(i);
            if (count == 2 * k) {
                int leftOr = 0;
                int rightOr = 0;
                int index = 0;
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        if (index < k) {
                            leftOr |= nums[j]; // First half OR
                        } else {
                            rightOr |= nums[j]; // Second half OR
                        }
                        index++;
                    }
                }
                // Calculate the XOR of OR results
                maxValue = Math.max(maxValue, leftOr ^ rightOr);
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        FindTheMaximumSequenceValueOfArray solution = new FindTheMaximumSequenceValueOfArray();
        int[] nums = { 4, 2, 5, 6, 7 };
        int k = 2;
        System.out.println(solution.maxValue(nums, k));
    }
}
