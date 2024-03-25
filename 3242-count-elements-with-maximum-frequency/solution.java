class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap <Integer,Integer> map= new HashMap<>();
        for (int num:nums)
        {
            if(!map.containsKey(num)) map.put(num,1); //add new ele
            else map.put(num,map.get(num)+1);//update freq
        }    
        int max=0,sum=0;
        Set <Integer> keys =map.keySet();
        for (int key:keys)
        {
            if(map.get(key)>max) {sum=map.get(key);max=sum;}
            else if(map.get(key)==max) sum+=map.get(key);
        }
        return sum;
    }
}
