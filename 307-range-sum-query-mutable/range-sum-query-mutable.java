class NumArray {
    private int[] tree;
    private int[] nums;
    private int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[n + 1];

        // Initialize Fenwick Tree
        for (int i = 0; i < n; i++) {
            initAdd(i + 1, nums[i]);
        }
    }
    
    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val; // Update original array
        
        // Update Fenwick Tree with the difference
        int i = index + 1;
        while (i <= n) {
            tree[i] += diff;
            i += i & (-i); // Move to the next responsible node
        }
    }
    
    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }

    private void initAdd(int i, int val) {
        while (i <= n) {
            tree[i] += val;
            i += i & (-i);
        }
    }

    // Returns prefix sum from index 1 to i
    private int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & (-i); // Move to parent node
        }
        return sum;
    }
}

