/*
 * @lc app=leetcode id=15 lang=csharp
 *
 * [15] 3Sum
 */

// @lc code=start

using System.Collections.Generic;
using System.Linq;

public class Solution
{
    public IList<IList<int>> ThreeSumV4(int[] nums)
    {
        Array.Sort(nums);
        List<IList<int>> answer = new List<IList<int>>();

        for (int i = 0; i < nums.Length - 2; i++)
        {
            if (nums[i] > 0)
            {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1])
            {
                continue;
            }
            var a = nums[i];
            var sum = -a;
            int lo = i + 1, hi = nums.Length - 1;
            while (lo < hi && nums[hi] >= 0)
            {
                int b = nums[lo], c = nums[hi];
                if (b + c == sum)
                {
                    answer.Add(new List<int> { a, b, c });
                    while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                    lo++;
                    hi--;
                }
                else if ((b + c) < sum)
                {
                    lo++;
                }
                else
                {
                    hi--;
                }
            }
        }
        return answer;
    }
    public IList<IList<int>> ThreeSumV3(int[] nums)
    {
        Array.Sort(nums);
        List<IList<int>> answer = new List<IList<int>>();
        Dictionary<int, List<int>> dic = new Dictionary<int, List<int>>();

        for (int i = 0; i < nums.Length; i++)
        {
            if (dic.ContainsKey(nums[i]))
            {
                dic[nums[i]].Add(i);
            }
            else
            {
                dic[nums[i]] = new List<int> { i };
            }
        }

        for (int i = 0; i < nums.Length - 2; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1])
            {
                continue;
            }
            var a = nums[i];
            if (a > 0)
            {
                break;
            }
            for (int j = nums.Length - 1; j > i + 1; j--)
            {
                var b = nums[j];
                if (b < 0)
                {
                    break;
                }
                if (j < (nums.Length - 1) && nums[j] == nums[j + 1])
                {
                    continue;
                }

                var c = -(a + b);
                if (dic.ContainsKey(c))
                {
                    var list = dic[c].Where(x => x > i && x < j).ToList();
                    if (list.Any())
                    {
                        answer.Add(new List<int> { a, c, b });
                    }
                }
            }
        }
        return answer;
    }

    public IList<IList<int>> ThreeSumV2(int[] nums)
    {
        Array.Sort(nums);
        List<IList<int>> answer = new List<IList<int>>();
        Dictionary<int, List<int>> dic = new Dictionary<int, List<int>>();
        HashSet<(int, int)> set = new HashSet<(int, int)>();
        for (int i = 0; i < nums.Length; i++)
        {
            if (dic.ContainsKey(nums[i]))
            {
                dic[nums[i]].Add(i);
            }
            else
            {
                dic[nums[i]] = new List<int> { i };
            }
        }
        for (int i = 0; i < nums.Length; i++)
        {
            var a = nums[i];
            for (int j = i + 1; j < nums.Length; j++)
            {
                var b = nums[j];
                if (set.Contains((a, b)))
                {
                    continue;
                }
                set.Add((a, b));

                var c = -(a + b);
                if (dic.ContainsKey(c))
                {
                    var list = dic[c].Where(x => x != i && x != j && x > j).ToList();
                    if (list.Any())
                    {
                        answer.Add(new List<int> { a, b, c });
                    }

                }
            }
        }
        return answer;
    }

    public IList<IList<int>> ThreeSumV1(int[] nums)
    {
        Array.Sort(nums);
        List<IList<int>> answer = new List<IList<int>>();
        for (int i = 0; i < nums.Length; i++)
        {
            for (int j = i + 1; j < nums.Length; j++)
            {
                for (int k = j + 1; k < nums.Length; k++)
                {
                    var a = nums[i];
                    var b = nums[j];
                    var c = nums[k];
                    if ((a + b + c) == 0)
                    {
                        var last = answer.LastOrDefault();
                        var newData = new List<int> { a, b, c };
                        if (last == null || !newData.All(last.Contains))
                        {
                            answer.Add(newData);
                        }
                    }
                }
            }
        }
        return answer;
    }
}
// @lc code=end

