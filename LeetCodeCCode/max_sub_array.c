#include <stdlib.h>

//Maximum Subarray �̤j�l�ƦC���D
int MaxSubArrayON3(int *nums, int numsSize){

    /* nums:[-2,1,-3,4,-1,2,1,-5,4]
       numsSize:9

    */

    int max = INT_MIN;

    //��ܤ@�Ӱ_�I
    for(int i=0; i<numsSize; i++){  //i:0,1...,numsSize-1 (0,1,2,3...8)

        //��ܤ@�Ӳ��I
        for(int j=i; j<numsSize; j++){  //j: i,......numsSize-1(0,1,2,3...8)
            //�p��q�_�I����I���M
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
 // (1+1000) * 1000/2 => �����B�z
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
// �ʺA�W��
int MaxSubArrayON(int *nums, int numsSize){

    int i=0, sum=0;
    int max = nums[0];

    for(i=0; i<numsSize;i++){

        sum+=nums[i];

        /*
        sum�x�s�ϥΤW�@�ӼƦr���s��M�Asum�[�W��e��m�Ʀr�A
        �p�G�M�j��0�A�h�����i�H�~��V��F�p��0�h�����A
        ��e��m�O�@�ӭt�ơA���ӱq�U�@�ӼƦr���s�}�l�C
        �P�ɤ]�n���_��smax�C

        */

        if(max<sum)
            max = sum;

        if(sum<0)
            sum = 0;

    }

    return max;

}
