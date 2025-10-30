class Solution {
    public int minNumberOperations(int[] target) {
        int ans=0 , prev=0;
        for(int x: target){
            if(x>prev)
                ans+=x-prev;
            prev=x;
        }
        return ans;
    }
}


// say arr = [3, 1, 4, 2]
//  imagine they are heights
// to reach heigth of arr[0]=3, we need 3 moves anyway

// meanwhile any samller or qal elemnts adjacent to this index is also reached
// but fore greater heights on adj indices, we needs arr[i] - arr[curr] more , so add this to ans
