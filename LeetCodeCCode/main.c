#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "algorithm_method.h"



int main()
{

    // Single Number
    int singleTest[5] = { 1, 1, 4, 2, 2 };
    int ans = SingleNumberON2(singleTest, 5);
    printf("The single number answer is %d\n", ans);

    // Single Number
    int anson = SingleNumberON(singleTest, 5);
    printf("The single number on answer is %d\n", anson);

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

    //ninenine();
    tree(4);
    return 0;
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
