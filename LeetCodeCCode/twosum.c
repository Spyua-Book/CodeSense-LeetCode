

// «ü¼Ð¨ç¥Ü int *fun(int a, int b);


int *twoSum(int* nums, int numSize, int target){

    int *ret = (int*)malloc(2*sizeof(int)),  i,j,temp;

    for(i=0; i<numSize; i++){

        temp = target - nums[i];

        for(j=i+1; j<numSize; j++){

            if(temp==nums[j]){

                ret[0] = i;
                ret[1] = j;

                return ret;
            }
        }

    }

    return ret;
}

