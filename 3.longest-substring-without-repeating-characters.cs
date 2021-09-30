/*
 * @lc app=leetcode id=3 lang=csharp
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
public class Solution
{
    // int[] charLastAppearIndex = new int[128];

    public int LengthOfLongestSubstring(string s)
    {
        HashSet<char> set = new HashSet<char>();
        int begin = 0;
        int end = 0;
        int answer = 0;
        while (end < s.Length)
        {
            if (!set.Contains(s[end]))
            {
                set.Add(s[end++]);
                answer = set.Count > answer ? set.Count : answer;

            }
            else
            {
                set.Remove(s[begin++]);
            }
        }
        return answer;
    }
    // public int LengthOfLongestSubstringV0(string s)
    // {
    //     for (int i = 0; i < charLastAppearIndex.Length; ++i)
    //     {
    //         charLastAppearIndex[i] = -1;
    //     }
    //     int answer = 0;
    //     int currentLength = 0;
    //     int currentStartIndex = 0;


    //     for (int i = 0; i < s.Length; i++)
    //     {
    //         var ch = s[i];
    //         var lastAppearIndex = charLastAppearIndex[ch];
    //         if (lastAppearIndex >= currentStartIndex)
    //         {
    //             currentStartIndex = lastAppearIndex + 1;
    //             currentLength = i - currentStartIndex;
    //         }
    //         currentLength += 1;
    //         charLastAppearIndex[ch] = i;

    //         if (currentLength > answer)
    //         {
    //             answer = currentLength;
    //         }
    //     }
    //     return answer;
    // }
}
// @lc code=end

