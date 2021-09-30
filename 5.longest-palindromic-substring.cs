/*
 * @lc app=leetcode id=5 lang=csharp
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
using System;
using System.Collections.Generic;
public class Solution
{
    public string LongestPalindrome(string s)
    {
        (int startIndex, int length) result = (0, 1);
        for (int i = 0; i < (s.Length - 1); i++)
        {
            var res = GetPalindrome(s, i, i+2);
            if (res.length > result.length)
            {
                result = res;
            }

            res = GetPalindrome(s, i, i+1);
            if (res.length > result.length)
            {
                result = res;
            }
        }
        return s.Substring(result.startIndex, result.length);
    }

    private (int startIndex, int length) GetPalindrome(string s, int startIndex, int end)
    {
        while (startIndex >= 0 && end < s.Length && s[startIndex] == s[end])
        {
            startIndex--;
            end++;
        }
        return (startIndex+1, end - startIndex - 1);
    }
    public string LongestPalindromeV1(string s)
    {
        HashSet<(int, int)> IsPalindromeSet = new HashSet<(int, int)>();
        string result = "";
        for (int i = s.Length; i > 0; i--)
        {
            for (int j = 0; j <= (s.Length - i); j++)
            {
                var begin = j;
                var end = (j + i - 1);
                int count = 0;
                while (begin <= end)
                {
                    if (IsPalindromeSet.Contains((begin, end)))
                    {
                        break;
                    }
                    if (begin == end)
                    {
                        return s.Substring(j, i);
                    }
                    if ((begin + 1) == end && s[begin] == s[end])
                    {
                        return s.Substring(j, i);
                    }
                    if (s[begin] == s[end])
                    {
                        begin += 1;
                        end -= 1;
                        count += 1;
                    }
                    else
                    {
                        for (int k = 0; k < count; k++)
                        {
                            IsPalindromeSet.Add((begin - k, end + k));
                        }
                        break;
                    }

                }
            }
        }
        return "";
    }
}
// @lc code=end

