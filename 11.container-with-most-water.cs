/*
 * @lc app=leetcode id=11 lang=csharp
 *
 * [11] Container With Most Water
 */

// @lc code=start
using System;
using System.Collections.Generic;

public class Solution
{

    public int MaxAreaV3(int[] height)
    {
        int answer = 0;
        int start = 0;
        int end = height.Length - 1;
        while (start < end)
        {
            var leftH = height[start];
            var rightH = height[end];
            var area = (end - start) * Math.Min(leftH, rightH);
            if (area > answer)
            {
                answer = area;
            }
            if (leftH <= rightH)
            {
                start++;
            }
            else
            {
                end--;
            }
        }
        return answer;
    }
    public int MaxArea(int[] height)
    {
        int answer = 0;
        int answerheightFront = 0;
        int answerJ = 0;
        int maxHeight = 0;
        var newHeightPosition = new List<int>();
        for (int i = 0; i < height.Length; i++)
        {
            int j = 0;
            var heightEnd = height[i];
            if (heightEnd == 0) continue;
            if (heightEnd > maxHeight)
            {
                newHeightPosition.Add(i);
                maxHeight = heightEnd;
            }

            if (heightEnd >= answerheightFront)
            {
                j = answerJ;
            }

            for (; j < newHeightPosition.Count; j++)
            {
                int frontPos = newHeightPosition[j];
                var heightFront = height[frontPos];
                var area = (i - frontPos) * Math.Min(heightEnd, heightFront);
                if (area > answer)
                {
                    answer = area;
                    answerheightFront = heightFront;
                    answerJ = j;
                }

                if (heightFront >= heightEnd)
                {
                    break;
                }
            }
        }
        return answer;
    }
    public int MaxAreaV1(int[] height)
    {
        int answer = 0;
        for (int i = 0; i < height.Length; i++)
        {
            for (int j = i + 1; j < height.Length; j++)
            {
                var area = (j - i) * Math.Min(height[i], height[j]);
                if (area > answer) answer = area;
            }
        }
        return answer;
    }
}
// @lc code=end

