class NumArray {
    int nums[];
    int sums[];
    int n;
    public NumArray(int[] nums) {
        this.nums = nums;
        n = this.nums.length;
        sums = new int[4*n];
        build(0, 0, n-1);
    }
    
    public void update(int index, int val) {
        upd(0, 0, n-1, index, val);
    }
    
    public int sumRange(int left, int right) {
        return sum(0,0,n-1,left, right);      
    }

    void build(int i, int low, int high){
        if (low==high){
            sums[i]=this.nums[low];
            return;
        }
        int mid = low + (high-low)/2;
        build(i*2+1, low, mid);
        build(i*2+2, mid+1, high);

        sums[i] = (sums[2*i+1] + sums[2*i+2]);
    }

    int sum(int i, int low, int high, int left, int right){
        if (right<low || left>high) return 0;
        if (low>=left && high<=right) return sums[i];

        int mid=low+(high-low)/2;

        int l=sum(i*2+1, low , mid, left, right);
        int r=sum(i*2+2, mid+1, high, left, right);
        return l+r;
    }

    void upd(int i, int low, int high, int index, int value){
        
        if (low==high) {
            // nums[index]=value;
            sums[i]=value;
            return;
        }

        int mid = low + (high-low)/2;

        if (index<=mid){
            upd(i*2+1, low, mid, index, value);
        }
        else
            upd(i*2+2, mid+1, high, index, value);
        sums[i]=sums[2*i+1]+sums[2*i+2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
