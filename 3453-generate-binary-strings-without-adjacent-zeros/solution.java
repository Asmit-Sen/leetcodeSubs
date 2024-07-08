class Solution {
void f(int idx, String num, List<String> ans, int n)
{
    if(idx == n) 
    {
        ans.add(num);
        return;
    }
    
    // Take 1 always
    f(idx + 1, num + "1", ans, n);
    
    // Take 0 only if the previous is not zero
    if(idx == 0 || num.charAt(num.length() - 1) == '1')
    {
        f(idx + 1, num + "0", ans, n);
    }
}

    public List<String> validStrings(int n) {
        List<String> ans=new ArrayList<>();
        f(0,"",ans,n);
        return ans;
    }
}
