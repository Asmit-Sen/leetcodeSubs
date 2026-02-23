class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < (int)Math.pow(2,k)) return false;

        Set<String> set = new HashSet<>();
        int l=0, r=0;
        while(r<s.length()){
            if (r-l+1==k){
                set.add(s.substring(l,r+1));
                l++;
                r++;
            }
            else
                r++;
        }
        // for(String st : set) System.out.println(st);
        return set.size()==(int)Math.pow(2,k);
    }
}
