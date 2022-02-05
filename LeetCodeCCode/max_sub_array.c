#include <stdlib.h>

//Maximum Subarray 最大子數列問題
int MaxSubArrayON3(int *nums, int numsSize){

    /* nums:[-2,1,-3,4,-1,2,1,-5,4]
       numsSize:9

    */

    int max = INT_MIN;

    //選擇一個起點
    for(int i=0; i<numsSize; i++){  //i:0,1...,numsSize-1 (0,1,2,3...8)

        //選擇一個終點
        for(int j=i; j<numsSize; j++){  //j: i,......numsSize-1(0,1,2,3...8)
            //計算從起點到終點的和
            // i:0, j:0
            // i:0, j:1
            // i:0, j:2
            // .....
            // i:1, j:1

            int sum = 0;
            for(int k=i; k<=j; k++){    // k=2,3,4,5...
                sum+=nums[k];
            }

            if(sum>max){
                max = sum;
            }

            //printf("%d %d:%d (%d)\n",i,j,sum, max);

        }
    }

    return max;

 }

 // 1+2+3+...+1000 => for
 // (1+1000) * 1000/2 => 公式處理
int MaxSubArrayON2(int *nums, int numsSize){

    int max = INT_MIN;
    for(int i=0; i<numsSize; i++){

        int sum = 0;
        for(int j=i; j<numsSize; j++){
            // sum = 0
            // i:0,j:0 => sum = nums[j]
            // i:0,j:1 => sum = sum+ nums[j]
            // i:0,j:2 => sum = sum+ nums[j]
            // ...
            // i:0, j:8 => sum = sum+nums[j]

            sum+=nums[j];

            if(sum>max){
                max = sum;
            }
        }
    }

    return max;

 }
// 動態規劃
int MaxSubArrayON(int *nums, int numsSize){

    int i=0, sum=0;
    int max = nums[0];

    for(i=0; i<numsSize;i++){

        sum+=nums[i];

        /*
        sum儲存使用上一個數字的連續和，sum加上當前位置數字，
        如果和大於0，則說明可以繼續向後；小於0則說明，
        當前位置是一個負數，應該從下一個數字重新開始。
        同時也要不斷更新max。

        */

        if(max<sum)
            max = sum;

        if(sum<0)
            sum = 0;

    }

    return max;

}
