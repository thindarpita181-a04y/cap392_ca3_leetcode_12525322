class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending in 0 (except 0 itself) are never palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reversedHalf = 0;
        
        // Reverse digits until we reach the middle of the number
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }
        
        // Check equality for even-length (x == reversedHalf) 
        // and odd-length numbers (x == reversedHalf / 10)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}

