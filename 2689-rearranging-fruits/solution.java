class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        // int freq[]= new int[(int)1e9+1];
        Map<Integer,Integer> freq = new HashMap<>();
        int mini=(int)1e9;

        for(int fruit :basket1)
        {
            mini=(int)Math.min(mini,fruit);
            freq.put(fruit, freq.getOrDefault(fruit,0)+1);
        }


        for(int fruit:basket2){
            mini=(int)Math.min(mini,fruit);
            freq.put(fruit, freq.getOrDefault(fruit,0)-1);
        }

        //check if its at all possible to make baskets equal
        //if any fruit occurs a total of odd no of times across both baskets, 
        //it cannot be made equal

        List<Integer> list = new ArrayList<>();
        for(int fruit : freq.keySet()){

            int count=freq.get(fruit);
            if(count%2!=0) return -1;
            //add whatever fruits need to be transferred
            //half of all the counts need to be swapped from one basket to the other

            //note that count of a fruit can be -ve if basket1 has less than basket2
            for(int j=0;j<(int)Math.abs(count)/2;j++)
                list.add(fruit);
        }
        Collections.sort(list);

        //out of all the fruits that we need to swap frm this list
        //we hae two options

        //option 1: sapping two fruits directly
        //sort the list, and greedily swap 
        //the first half of fruit with the second half, 
        //making the cost = cost of first half fruits

        //option 2: sapping two fruits via a third one, (the mini fruit with least cost)
        // swap fruit a with mini (cost = mini)
        // swap mini again with b (cost = mini again), total cost = mini*2 total

        //net answer = minimum of these two choices for all fruits to be swapped

        long cost=0;
        for(int i=0;i<list.size()/2;i++){
            int x=list.get(i);
            int y=2*mini;

            cost+=(int)Math.min(x,y);
        }

        return cost;

    }
}
