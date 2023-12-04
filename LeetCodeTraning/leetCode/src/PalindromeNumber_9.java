import org.junit.Assert;
import org.junit.Test;

public class PalindromeNumber_9 {

    @Test
    public void PalindromeNumberUnitTest() {
        Assert.assertTrue(isPalindromeByStringSolution(12121));
        Assert.assertFalse(isPalindromeByStringSolution(-121));
        Assert.assertFalse(isPalindromeByStringSolution(10));


        Assert.assertTrue(isPalindrome(12121));
        Assert.assertFalse(isPalindrome(-121));
        Assert.assertFalse(isPalindrome(10));
    }

    public static boolean isPalindromeByStringSolution(int x) {
        if(x<0)
            return false;

        String str = String.valueOf(x);
        int length = str.length();

        // 從中間開始 頭往右，尾往左這樣一個一個比
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int x) {
        // 負數不是回文數
        if (x < 0) {
            return false;
        }

        int original = x;
        int reversed = 0;

        // 反轉數字
        /* 第一次迭代
           123 % 10 => 3
            0 * 10 + 3 => 3
           123/10 = 12 (x)

             第二次迭代
           12 % 10 => 2
             3 * 10 + 2 => 32
           12 / 10 = 1

           第三次迭代
           1 % 10 => 1
           32*10 + 1 => 321
           1 / 10 = 0
				*/
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        // 比較原始數字與反轉後的數字
        return original == reversed;
    }
}
