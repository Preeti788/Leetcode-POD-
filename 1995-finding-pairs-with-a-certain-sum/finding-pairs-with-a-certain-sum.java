class FindSumPairs {
    int[] nums1, nums2;
    Map<Integer, Integer> freq;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        freq = new HashMap<>();
        for (int num : nums2) freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    public void add(int index, int val) {
        int old = nums2[index], updated = old + val;
        freq.put(old, freq.get(old) - 1);
        if (freq.get(old) == 0) freq.remove(old);
        nums2[index] = updated;
        freq.put(updated, freq.getOrDefault(updated, 0) + 1);
    }

    public int count(int tot) {
        int res = 0;
        for (int x : nums1) res += freq.getOrDefault(tot - x, 0);
        return res;
    }
}


/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */