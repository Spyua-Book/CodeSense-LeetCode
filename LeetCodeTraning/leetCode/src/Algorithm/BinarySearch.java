package Algorithm;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearch {

    // 必須是已經排序過的(以小到大排序為例)才可使用

    @Test
    public void BinarySearchDivideTest(){
      
        int[] nums = {1,2,3,4};        
        var result = Iterative(nums, 2);      
        Assert.assertTrue(result==1);
    }

    
    public int Iterative(int[] array, int num){

        int left = 0, right= array.length-1;

        while(left<=right){
            // 取出搜索範圍中點的元素
            int middle = (right+left)/2;

            if(array[middle] == num)
                return middle;

            if(array[middle] > num)
                // 若小於則將左邊邊界改為中點右側
                return right = middle -1;
                // 若大於則將右邊邊界改為中點左側
            else
                return left = middle +1;

        }

        // 左邊邊界不超過右邊邊界(還有資料)則重複以上動作，若已無資料則回傳-1
        return -1;
    }


    public class DivideAndConquer{
        
        public int Search(int[] array, int num)
        {
            return Search(array, num, 0, array.length - 1);
        }
 
        public int Search(int[] array, int num, int left, int right)
        {
            if (left > right)
                return -1;
 
            int middle = (right + left) / 2;
 
            if (array[middle] == num)
                return middle;
 
            if (array[middle] > num)
                return Search(array, num, left, middle - 1);
 
            return Search(array, num, middle + 1, right);
        }
        
    }
}
