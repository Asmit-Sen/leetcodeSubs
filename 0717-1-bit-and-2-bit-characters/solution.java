class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        // 0  -> a
        // 10 -> b
        // 11 -> b

        // ends with a = true
        // ends with b = false

        // bit = 0 -> move 1 place as 0 is itself valid only
        // bit = 1 -> move two places as both 10 and 11 are valid pairs
        
        int n=bits.length;
        for(int i=0;i<n;){
            if(i==n-1) return true;

            if(bits[i]==0) i++;
            else i+=2;
        }
        return false;

    }
}
