import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class twoSum_01 {
    
    @Test
    public void twoSumUnitTest() {


        int i = 1;
        while (i < 10)
            if (i % 2 == 0)
                System.out.println(i++);


        var season =1;
        switch (season){
            case 1:
                System.out.println("請穿著長袖出門");
            case 2:
                System.out.println("請穿著短袖出門");
                break;
            case 3:
                System.out.println("請加件長袖輕薄外套出門");
                break;
            case 4:
                System.out.println("請穿著毛衣或大衣出門");
                break;
        }


      var twoSum = new twoSum_01();
      int[] nums = {2,7,11,15};
      int target = 9;  
      int[] result = twoSum.twoSumHash(nums, target);
      Assert.assertEquals(result[0], 0);
      Assert.assertEquals(result[1], 1);
    }

    public int[] twoSumHash(int[] nums, int target) {

        // O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++){   
                   
            int anserTemp = target - nums[i];
            
            if(map.containsKey(anserTemp)){       
                result[0] = map.get(anserTemp);
                result[1] = i;
                return result;
            }                
            // Save resultTemp and nums index
            map.put(nums[i], i);
        }
    
        if(result[0]==0 && result[1]==0)
            return null;

        return result;

       
    }



}




