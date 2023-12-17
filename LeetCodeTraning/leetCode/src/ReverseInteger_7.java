import org.junit.Test;

public class ReverseInteger_7 {

    @Test
    public void UnitTest() {
        var result = reverse(-123);
    }
    public int reverse(int x) {

        if (x == Integer.MIN_VALUE) {
            return 0; // Directly return 0 for the edge case
        }

        boolean isNegative = x < 0;
        if (isNegative) {
            x *= -1;
        }

        int reverseValue = 0;
        while (x != 0) {
            int digit = x % 10;
            // Check for overflow before actually reversing
            if (reverseValue > Integer.MAX_VALUE / 10 || (reverseValue == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            reverseValue = reverseValue * 10 + digit;
            x /= 10;
        }

        reverseValue = isNegative ? reverseValue * -1 : reverseValue;
        return reverseValue;
    }

    public int gptReverse(int x){
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check for overflow/underflow
            if (reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (reversed < Integer.MIN_VALUE/10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) return 0;

            reversed = reversed * 10 + digit;
        }

        return reversed;
    }

}
