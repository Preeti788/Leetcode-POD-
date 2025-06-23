class Solution {
    public long kMirror(int k, int n) {
         long sum = 0;
        int count = 0;
        int length = 1;

        while (count < n) {
            for (long num : generatePalindromes(length)) {
                if (isPalindrome(toBase(num, k))) {
                    sum += num;
                    count++;
                    if (count == n) return sum;
                }
            }
            length++;
        }

        return sum;
    }

    private List<Long> generatePalindromes(int len) {
        List<Long> palindromes = new ArrayList<>();

    
        int half = (len + 1) / 2;
        long start = (len == 1) ? 1 : (long) Math.pow(10, half - 1);
        long end = (long) Math.pow(10, half);

        for (long i = start; i < end; i++) {
            String left = Long.toString(i);
            String right = new StringBuilder(left.substring(0, len % 2 == 0 ? left.length() : left.length() - 1)).reverse().toString();
            String full = left + right;
            palindromes.add(Long.parseLong(full));
        }

        return palindromes;
    }


    private String toBase(long num, int base) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % base);
            num /= base;
        }
        return sb.reverse().toString();
    }


    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
        
    }
}