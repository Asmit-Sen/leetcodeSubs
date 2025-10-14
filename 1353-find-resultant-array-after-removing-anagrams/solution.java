class Solution {
    public List<String> removeAnagrams(String[] words) {
        List <String> list = new ArrayList<>();

        for(int i=0; i<words.length; i++){
            //check for anagrams
            char [] word = words[i].toCharArray();
            Arrays.sort(word);
            list.add(new String(word));
        }

        List <String> ans = new ArrayList<>();
        ans.add(words[0]);
        for(int i=1;i<list.size();i++){
            if(list.get(i).equals(list.get(i-1))) continue;
            ans.add(words[i]);
        }

        return ans;
    }
}
