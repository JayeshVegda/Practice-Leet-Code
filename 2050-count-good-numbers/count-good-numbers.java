class Solution {
    final int MOD=1000000007;
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;
        long evenpow=mpow(5,even);
        long oddpow=mpow(4,odd);
        return (int)((evenpow*oddpow)%MOD);
    }
    public long mpow(long b,long ex){
        long res=1;
        while(ex>0){
            if(ex%2==1){
                res=(res*b)%MOD;
            }
            b=(b*b)%MOD;
            ex/=2;
        }
        return res;
    }
}