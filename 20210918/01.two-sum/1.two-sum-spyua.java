import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {

        // O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++){   
            int anserTemp = target - nums[i];
            if(map.containsKey(anserTemp)){       
                result[0] = i;
                result[1] = map.get(anserTemp);
                return result;
            }                
            map.put(nums[i], i);
        }
        
        return result;
    }
}
// @lc code=end

