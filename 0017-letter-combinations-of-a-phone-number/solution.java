class Solution {

    void f(String digits, String arr[], String word, List<String> ans,int idx)
    {
        //base cases
        if(idx>=digits.length()) 
        {
            if(word.length()==0)return ;
            ans.add(word);
            return;
        }

        String curr=arr[digits.charAt(idx)-'0']; //abc, def
        for(int i=0;i<curr.length();i++)
        {
            f(digits,arr,word+curr.charAt(i),ans,idx+1);
        }
    }

    public List<String> letterCombinations(String digits) {
        String arr[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans=new ArrayList<>();
        f(digits,arr,"",ans,0);
        return ans;
    }
}
