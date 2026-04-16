class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int ans = 0;
        int n = words.length;
        int left = startIndex, right = startIndex;
        while(ans<=n){
            if (words[left].equals(target) || words[right].equals(target)) return ans;
            left = (left - 1 + n) % n;
            right = (right + 1) % n;
            ans++;
        }
        return -1;
    }
}
