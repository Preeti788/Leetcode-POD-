class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getSumOfSquares(n);
        
        while (fast != 1 && slow != fast) {
            slow = getSumOfSquares(slow);
            fast = getSumOfSquares(getSumOfSquares(fast));
        }
        
        return fast == 1;
    }
    
    private int getSumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}
