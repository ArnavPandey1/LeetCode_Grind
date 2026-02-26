import java.math.BigInteger;
class Solution {
    public int numSteps(String s) {
        BigInteger total=new BigInteger(s,2);
        int c=0;
        while(total.compareTo(BigInteger.ONE)>0){
            if(total.mod(BigInteger.TWO)==BigInteger.ZERO){
                total=total.divide(BigInteger.TWO);
            }else{
                total=total.add(BigInteger.ONE);
            }
            c++;
        }
        return c;
    }
}