

/* 題目
    nums : [2, 2,1]
    return 1

    nums : [4,1,2,1,2]
    return 4

    找出未重複數值
*/


// Single Number
int SingleNumberON2(int *nums, int numSize){


    /*
    指標
    *(nums+0) ==2
    *(nums+1) ==2
    *(nums+2) ==1

     nums[0] = *(nums+0) => 常用
    */


    for(int i=0; i<numSize; i++)
    {

        int count = 0;

        for(int j=0; j< numSize; j++){

                if(nums[j]==nums[i]){
                    count++;
                }
        }

        if(count == 1){
            return nums[i];
        }
    }

    return -1;
}



int SingleNumberON(int *nums, int numSize){

  // nums:[2,2,1], numSize: 3

    // n = nums[0] * nums[1] ^ nums[2]   ;/^:bitwise XOR

    // int => sizeof(int) == 4 bytes
    // 1 byte = 8 bits
    // 1 bit = [0] or [1]

    /*
    ^
    0^0 => 0
    1^1 => 0
    0^1 => 1
    1^0 => 1
    */

    /*
     1) A ^ A =>0
     2) A ^ 0 =>A
     3) A ^ B => B ^ A 交換率
    */


    int n = nums[0];

    for(int i=1; i<numSize; i++){   // i:1,2
        n = n ^ nums[i];
    }

    return n;
}
