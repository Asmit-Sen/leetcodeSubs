class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder fraction = new StringBuilder();
        
        long num=Math.abs(Long.valueOf(numerator));
        long den=Math.abs(Long.valueOf(denominator));
        
        if((numerator<0 && denominator>0) || (numerator>0 && denominator<0))
        fraction.append("-");
        
        long quotient = num / den;
        fraction.append(quotient);

        long rem=num % den;
        if(rem==0) return fraction.toString();

        fraction.append(".");
        Map<Long,Integer> map =new HashMap<>();
        while(rem!=0){
            if(map.containsKey(rem)){
                int pos=map.get(rem);
                fraction.insert(pos, "(").append(")");
                return fraction.toString();
            }
            map.put(rem, fraction.length());
            num=rem;
            num*=10;
            quotient=num/den;
            fraction.append(quotient);
            rem=num%den;
        }
        return fraction.toString();
    }
}
