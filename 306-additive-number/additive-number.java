import java.math.BigInteger;

class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        if (n < 3) return false;

        // Iterate through all valid choices for the first number (num1)
        for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) break; // Leading zeros not allowed
            
            // Iterate through all valid choices for the second number (num2)
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (num.charAt(i) == '0' && j > 1) break; // Leading zeros not allowed
                
                String num1 = num.substring(0, i);
                String num2 = num.substring(i, i + j);
                
                if (isValid(num1, num2, i + j, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(String s1, String s2, int k, String num) {
        while (k < num.length()) {
            // Use BigInteger to handle large numbers without overflow
            BigInteger n1 = new BigInteger(s1);
            BigInteger n2 = new BigInteger(s2);
            BigInteger sum = n1.add(n2);
            String sumStr = sum.toString();

            // Check if the remaining string starts with the calculated sum
            if (!num.startsWith(sumStr, k)) {
                return false;
            }

            k += sumStr.length();
            s1 = s2;
            s2 = sumStr;
        }
        return true;
    }
}