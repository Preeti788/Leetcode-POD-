class Solution {
    public int hIndex(int[] citations) {

        int n = citations.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (citations[j] < citations[minIdx]) {
                    minIdx = j;
                }
            }
    
            int temp = citations[i];
            citations[i] = citations[minIdx];
            citations[minIdx] = temp;
        }

        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}
