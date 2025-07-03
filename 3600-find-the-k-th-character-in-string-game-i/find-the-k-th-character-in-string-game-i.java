class Solution {
    public char kthCharacter(int k) {
        

        char[] result = new char[k];
        result[0] = 'a';
        int len = 1;

        while (len < k) {
            int currLen = len; 
            for (int i = 0; i < currLen && len < k; i++) {
                char nextChar = (char)((result[i] - 'a' + 1) % 26 + 'a');
                result[len++] = nextChar;
            }
        }

        return result[k - 1];
    }
}
