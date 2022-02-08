#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "algorithm_method.h"



int main()
{

    // Single Number
    int singleTest[5] = { 1, 1, 4, 2, 2 };
    int singleNumberAns= SingleNumberON2(singleTest, 5);
    printf("The single number answer is %d\n", singleNumberAns);

    // Single Number
    int singleNumberAnsOn = SingleNumberON(singleTest, 5);
    printf("The single number on answer is %d\n", singleNumberAnsOn);

    // IsHappy
    int num = 19;
    bool ishappy = IsHappy(num);
    printf("%d IsHappy=>%d\n",num, ishappy);

    // Maximum Subarray
    int subArray[9] = { -2,1,-3,4,-1,2,1,-5,4 };
    int maxArray = MaxSubArrayON2(subArray, 9);
    printf("Max Array=>%d\n",maxArray);


    int maxArrayON = MaxSubArrayON(subArray, 9);
    printf("Max Array ON =>%d\n",maxArrayON);

    // Two Sum
    int twoSumArray[4] = {2,7,11,15};
    int target=9;
    int *twoSumAns = twoSum(twoSumArray,4,9);
    printf("Two Sum=> Target:%d  Ans1:%d Ans2:%d\n",target, twoSumAns[0], twoSumAns[1]);
    free(twoSumAns);

    /*
    char *output = transferLowcaseChar("A");
    printf("%c\n",output);
    */

    int A=1, C=3;
    // 宣告一個ptrA指標指向A記憶體位置 @=A 指向A的記憶體位置 @=&A 指向A記憶體位值
    int *ptrA = &A;
    // ptrA為 A的記憶體位置, *ptrA為A的記憶體位置資料, 所以此意思為傳入A記憶位置
    func(ptrA);
    printf("%d\n", *ptrA);


    int *ptrB = &A;
    func2(&ptrB);
    printf("%d\n", *ptrB);

    printf("\n");
    return 0;
}

int B=2;


void func(int *p){
    // *p 指向 ptrA的記憶體位置
    p=&B;

}


void func2(int **p){
    *p=&B;

}


// 99 Test
void ninenine(){

    // 1*1, 1*2, 1*3...1*9
    // 2*1, 2*2, 2*3...2*9
    // ...

    for(int i=1; i<=9; i++){

        printf("\n");

        for(int j=1; j<=9; j++){

             printf("%d * %d = %d\t", i, j, i*j);

            if(j%3==0)
                printf("\n");


        }

    }

}

// Tree Test
void tree(int layer){
    /*
        *       4-1
       ***      4-2
      *****     4-3
     *******    4

     1,3,5,7 -> 4 layer
    */

    for(int i=layer; i>=1; i--){

        // Space
        for(int j=0; j<i-1; j++)
            printf(" ");

        // Star
        for(int k=0; k< (layer-i)*2+1; k++)
            printf("*");

        printf("\n");
    }
}

// ¤j¼gÂà¤p¼g

/*
char *transferLowcaseChar(char *input){
    return input +32;
}
*/
