class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b)-> a[0]-b[0]);

        // int room[] = new int[3];
        // (room number, endTime, no of meeting so far held)

        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a,b) -> (a[0]-b[0])
        );

        PriorityQueue<int[]> booked = new PriorityQueue<>(
            (a,b) -> (a[2]==b[2]) ? (a[0]-b[0]) : (a[2]-b[2])
        );

        //push all the unoccupied room to the heap
        for(int i=0;i<n;i++)
            available.offer(new int[]{i,0,0});

        int index = 101, attended = 0;

        for(int meeting[]: meetings){
            int start = meeting[0];
            int end = meeting[1];

            while(!booked.isEmpty() && booked.peek()[2]<=start){
                //move them from booked to available is finished
                int prev[] = booked.poll();
                prev[2]=0;
                available.offer(prev);
            }

            int top[]= new int[3];
            if (!available.isEmpty()){
                //atleast one room is currently free
                top = available.poll();
                // System.out.println("current room : " + top [0] + ", " + top[1] + ", " + top[2]);
                top[1]++;
                top[2] = end;
                booked.offer(top);
                // System.out.println("pushed room : " + top [0] + ", " + top[1] + ", " + top[2]);
            }else {
                //no room wa available, hence delayed
                top = booked.poll();
                // System.out.println("current room : " + top [0] + ", " + top[1] + ", " + top[2]);
                top[1]++;
                top[2] = top[2] + end - start;
                booked.offer(top);
                // System.out.println("pushed room : " + top [0] + ", " + top[1] + ", " + top[2]);
            }
            // update the ans found so far
            if (top[1]>attended){
                attended = top[1];
                index=top[0];
            }
            else if (attended==top[1]){
                index = (int)Math.min(index,top[0]);
            }
        }

        return index;
    }
}
