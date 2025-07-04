class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        List<Long> lengths = new ArrayList<>();
        lengths.add(1L); 

        for (int i = 0; i < n; i++) {
            long prev = lengths.get(i);
            long next = Math.min(prev * 2, k); 
            lengths.add(next);
        }

        int shift = 0;

        for (int i = n - 1; i >= 0; i--) {
            long len = lengths.get(i);
            long half = len;

            if (k > half) {
                k -= half;
                if (operations[i] == 1) {
                    shift++; 
                }
            }
        }

    
        char result = (char) ((('a' - 'a') + shift) % 26 + 'a');
        return result;
    }
}
