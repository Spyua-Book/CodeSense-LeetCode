#include <stdbool.h>

// IsHappy - �t���ɶ](�ֺC���w) - cycle detection
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

    //int �̤j��2147483647 10��Ʀr


    // �t���ɶ]
    int slow = n;
    int fast = n;

    do{
        // �Q�t���@�B
        slow = next_n(slow);
        // �ߤl����B
        fast = next_n(fast);
        fast = next_n(fast);
    }while(slow != fast);

    return fast ==1;

    /* �@��@�k
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
