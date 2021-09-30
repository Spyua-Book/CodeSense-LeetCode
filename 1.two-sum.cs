/*
 * @lc app=leetcode id=1 lang=csharp
 *
 * [1] Two Sum
 */

// @lc code=start
using System;
using System.Collections.Generic;

    public class Solution
    {
        public int[] TwoSum(int[] nums, int target)
        {
            var dictionary = new Dictionary<int, int>();
            int i = 0;
            foreach (var num in nums)
            {
                if (dictionary.ContainsKey(num))
                {
                    return new[] { dictionary[num], i };
                }
                dictionary[target - num] = i;
                i++;
            }
            return null;
        }
        // public int[] TwoSum(int[] nums, int target) {
        //     var dictionary = new Dictionary<int, int>();
        //     int i = 0;
        //     foreach (var num in nums)
        //     {
        //         if (dictionary.ContainsKey(target-num)) {
        //             return new[]{dictionary[target-num],i};
        //         }
        //         if (!dictionary.ContainsKey(num))
        //         {
        //             dictionary.Add(num, i);
        //         }
        //         i++;
        //     }
        //     return null;
        // }
    }

// @lc code=end