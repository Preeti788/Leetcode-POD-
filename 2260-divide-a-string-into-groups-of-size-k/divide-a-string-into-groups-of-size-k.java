class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int totalGroups = (n+k-1)/k;
        String[] result = new String[totalGroups];

        for(int i=0; i<totalGroups; i++){
            int start = i*k;
            int end = Math.min(start + k, n);
            String group = s.substring(start, end);

            if(group.length() < k){
                int fillsNeeded = k-group.length();
                StringBuilder sb = new StringBuilder(group);
                for(int j=0; j<fillsNeeded; j++){
                    sb.append(fill);
                }
                group = sb.toString();
            }

            result[i] = group;
        }
        
        return result;
    }
}