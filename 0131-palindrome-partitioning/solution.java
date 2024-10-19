class Solution {
    void part(String str, int idx, List<String> list, List<List<String>> ans)
    {
        if(idx==str.length()) 
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx; i<str.length();i++)
        {
            if(palin(str.substring(idx,i+1)))
            {
                list.add(str.substring(idx,i+1));
                part(str,i+1,list,ans);// once a plain substring is added, we recursively try to form plain substrings from the forward parts of the string
                list.remove(list.size()-1);
            }
        }
        
    }
    boolean palin(String str)
    {
        int l=0,r=str.length()-1;
        while(l<=r)
        {
            if(str.charAt(l++)!=str.charAt(r--))
            return false;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans= new ArrayList<>();
        part(s,0,new ArrayList<String>(), ans);
        return ans;

    }
}
