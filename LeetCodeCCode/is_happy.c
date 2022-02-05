#include <stdbool.h>

// IsHappy - 龜兔賽跑(快慢指針) - cycle detection
bool IsHappy(int n){
    /*
    if n = 19

    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1

    1 return true!

    if it's cycle detection return false
    */

    // n:12345
    // 1,2,3,4,5
    // next n = 1*1+2*2+3*3+4*4+5*5

    //int 最大為2147483647 10位數字


    // 龜兔賽跑
    int slow = n;
    int fast = n;

    do{
        // 烏龜走一步
        slow = next_n(slow);
        // 兔子走兩步
        fast = next_n(fast);
        fast = next_n(fast);
    }while(slow != fast);

    return fast ==1;

    /* 一般作法
    int histotry[10000];
    int size = 0;

    while(!Contains(histotry, size, n)){
        histotry[size] = n;
        size++;

        n = next_n(n);
    }


    return n==1;

    */
}

bool Contains(int *history, int size, int n){

    for(int i=0; i<size; i++){
        if(history[i]==n)
            return true;
    }

    return false;
}

int next_n(int n){

    int r = 0;
    while(n!=0){
        int d = n%10;
        n/=10;
        r+=d*d;
    }
    return r;
    /*
    int r = 0;
    int m = 1;
    // d = n/10 % 10....
    for(int k=1; k<=10; k++){
        int d = n/m %10;
        r+=d*d;
        m*=10;
    }

    return r;
    */

}
