class Solution {
    private final String[] LESS_THAN_20 = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    
    private final String[] TENS = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    
    private final String[] THOUSANDS = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int i = 0;
        StringBuilder result = new StringBuilder();

        // Process the number in chunks of 3 digits from right to left
        while (num > 0) {
            if (num % 1000 != 0) {
                StringBuilder chunk = new StringBuilder();
                helper(num % 1000, chunk);
                
                if (!THOUSANDS[i].isEmpty()) {
                    chunk.append(THOUSANDS[i]).append(" ");
                }
                
                result.insert(0, chunk);
            }
            num /= 1000;
            i++;
        }

        return result.toString().trim();
    }

    // Converts any number from 1 to 999 into words
    private void helper(int num, StringBuilder sb) {
        if (num == 0) {
            return;
        } else if (num < 20) {
            sb.append(LESS_THAN_20[num]).append(" ");
        } else if (num < 100) {
            sb.append(TENS[num / 10]).append(" ");
            helper(num % 10, sb);
        } else {
            sb.append(LESS_THAN_20[num / 100]).append(" Hundred ");
            helper(num % 100, sb);
        }
    }
}
