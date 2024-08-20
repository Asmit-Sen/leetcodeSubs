class Solution {
    public int[] asteroidCollision(int[] arr) {
        //Stack <Integer> st=new Stack<>();
        List <Integer> list=new ArrayList<>();
        // for(int num:asteroids)
        // {
        //     if(st.isEmpty() || num>0)
        //         {
        //             st.add(num);
        //             continue;
        //         }

        //     if(num<0)
        //     {
        //         if(st.get(st.size()-1)<0) 
        //             {
        //                 st.add(num); //put -ve in if the topis -ve, hence no collision;
        //                 continue;
        //             }

        //         while(!st.isEmpty() && st.get(st.size()-1)<(int)Math.abs(num))
        //         st.remove(st.size()-1); //pop all the smaller +ve asteroids

        //         if(st.isEmpty()) st.add(num); // put -ve only if all smaller +ve are out
        //         // else the larger +ve remain and the negative is skipped
        //         else 
        //             if((st.get(st.size()-1)==-num))
        //             st.remove(st.size()-1); // equals get destroyed

        //     }
        // }

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>0)
            list.add(arr[i]);
            else // arr[i] is -ve
            {
                while(list.size()!=0 && list.get(list.size()-1)>0 && list.get(list.size()-1)<-(arr[i]))
                list.remove(list.size()-1);
                if(list.size()==0 || list.get(list.size()-1)<0)
                    list.add(arr[i]);
                else if (list.get(list.size()-1) == -arr[i])
                    list.remove(list.size()-1);
                else 
                    continue;
            }
        }

        int ans[]=new int[list.size()];
        for(int i=0;i<list.size();i++)
        ans[i]=list.get(i);
        return ans;
    }
}
