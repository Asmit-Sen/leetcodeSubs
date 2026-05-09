class Solution {
    public int[] scoreValidator(String[] events) {
        int score = 0, cnt = 0;
        for(String x : events){
            if( cnt==10) break;
            if (x.equals("W")) cnt++;
            else if (x.equals("WD") || x.equals("NB")) score++;
            else score += Integer.parseInt(x);
        }
        return new int[]{score, cnt};
    }
}
