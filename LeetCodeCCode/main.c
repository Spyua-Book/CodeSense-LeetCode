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

    return 0;
}


