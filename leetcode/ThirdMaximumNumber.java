import java.util.*;

public class ThirdMaximumNumber {
  // public int thirdMax(int[] nums) {
  //   Arrays.sort(nums);
  //   int first = Integer.MIN_VALUE;
  //   int i = nums.length-1;;

  //   while(i>0) {
  //     if(nums[i] !=nums[i-1]) {
  //       if(first != Integer.MIN_VALUE) {
  //         return nums[i-1];
  //       } 

  //       first = nums[i];
  //     }

  //     i--;
  //   }

  //   return nums[nums.length-1];
  // }

  // public int thirdMax(int[] nums) {
  //   Integer max1 = null;
  //   Integer max2 = null;
  //   Integer max3 = null;

  //    for(Integer num: nums) {
  //     if(num.equals(max1) || num.equals(max2) || num.equals(max3)) continue;
  //     if(max1==null || num > max1) {
  //       max3=max2;
  //       max2=max1;
  //       max1=num;
  //     } else if (max2==null || num > max2 ) {
  //       max3=max2;
  //       max2=num;
  //     } else if(max3==null || num > max3 ){
  //       max3=num;
  //     }
  //   }

  //   return max3 == null ? max1 : max3;
  // }

  // optimize time
  public int thirdMax(int[] nums) {
    long firstMax = Long.MIN_VALUE,secondMax = Long.MIN_VALUE,thirdMax = Long.MIN_VALUE;
  for (int i = 0; i < nums.length; i++) {
      if(nums[i]> firstMax)
      {
          thirdMax = secondMax;
          secondMax = firstMax;
          firstMax = nums[i];
      }else if(nums[i]> secondMax && nums[i] < firstMax)
      {
          thirdMax = secondMax;
          secondMax = nums[i];
      }else if( nums[i] > thirdMax && nums[i] < secondMax)
      {
          thirdMax = nums[i];
      }
  }
  return (int)(thirdMax == Long.MIN_VALUE ? firstMax: thirdMax);
}


  public static void main(String[] args) {
    ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();
    int[] nums = {-2147483648,-2147483648,-2147483648,-2147483648,1,1,1};
    System.out.println(thirdMaximumNumber.thirdMax(nums));
  }
}
