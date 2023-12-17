import org.junit.Test;

public class RemoveElement_27 {

    @Test
    public void Test() {
        int[] l1 = {3,2,2,3};

    }


    public int removeElement(int[] nums, int val) {
        int meetValCnt = 0;
        if(nums.length!=0){
          for(int i=0; i<=nums.length; i++){
              if(nums[i]!=val){
                  meetValCnt++;
              }
          }
        }
        return meetValCnt;
    }

}
