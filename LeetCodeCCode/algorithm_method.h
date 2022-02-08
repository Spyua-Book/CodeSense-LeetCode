#ifndef ALGORITHM_METHOD_H_INCLUDED
#define ALGORITHM_METHOD_H_INCLUDED

extern bool IsHappy(int n);

extern int SingleNumberON2(int *nums, int numSize);
extern int SingleNumberON(int *nums, int numSize);

int MaxSubArrayON3(int *nums, int numsSize);
int MaxSubArrayON2(int *nums, int numsSize);
int MaxSubArrayON(int *nums, int numsSize);


int *twoSum(int* nums, int numSize, int target);
#endif // ALGORITHM_METHOD_H_INCLUDED
