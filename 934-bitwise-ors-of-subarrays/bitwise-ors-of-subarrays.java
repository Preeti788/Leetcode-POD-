class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        
    
        Set<Integer> res = new HashSet<>();
        Set<Integer> curr = new HashSet<>();
        Set<Integer> next = new HashSet<>();

        for (int a : arr) {
            next.clear();
            next.add(a);

            for (int x : curr) {
                next.add(x | a);
            }

            res.addAll(next);

           
            Set<Integer> temp = curr;
            curr = next;
            next = temp;
        }

        return res.size();
    }
}

   