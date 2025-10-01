class Solution {
public:
    int minTimeToType(string s) {
        int c=0;
        char prev='a';
        for(int i=0; i<s.size(); i++){
            c+=min(abs(s[i]-prev), 26-abs(s[i]-prev));
            prev=s[i];
        }
        return c+s.size();
    }
};
