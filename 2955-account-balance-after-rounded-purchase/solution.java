class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        Scanner sc=new Scanner (System.in);
        int pamt=purchaseAmount;
        int total=100, ramt=0;

        if(pamt%10==0){ramt=pamt;}
        else if (pamt%10<5){ramt=pamt-(pamt%10);}
        else{ramt=pamt+(10-(pamt%10));}
        return (total-ramt);
    }
}
