import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArray_33 {
    // Binary Search變形. 遞迴、跌代對於陣列的處裡

    @Test
    public void SearchInRotatedSortedArrayCase0(){
        int[] nums = {4,5,6,7,0,1,2};
        var result = Search(nums, 0);
        Assert.assertTrue(result == 4);
    }
    
    // Iterative
    public int Search(int[] nums, int target) {
        
        int left = 0, right = nums.length-1;

        while(left<right) {

            int mid = left + (right-left)/2;
            
            if(nums[mid]==target) 
                return mid;  
            
            // 每次要能判斷出target位於左半還是右半序列

            // 起始元素0在中間左邊 --> EX 6 7 0 1 2 4 5 : 1<5
            if(nums[mid]<nums[right]) { 

                // Binary Search

                // mid target end : 往右找
                if(target>nums[mid] && target<=nums[right])
                    left = mid+1;
                // target mid end : 往左找
                else
                    right = mid-1;
            }
            // 起始元素0在中間右邊 --> EX 4,5,6,7,0,1,2 : 7>2
            else {  

                // Binary Search

                 // target mid end : 往左找
                if(target>=nums[left] && target<nums[mid]) 
                    right = mid-1;
                // mid target end : 往右找
                else
                    left = mid+1;
            }
        }
        return -1;
       
    }


}
