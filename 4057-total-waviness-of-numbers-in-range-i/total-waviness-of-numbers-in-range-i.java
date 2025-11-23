class Solution {
    public int totalWaviness(int num1, int num2) {
        int sum=0;
        for(int i=num1;i<=num2;i++){
            String s=String.valueOf(i);
            if(s.length()<3)
                continue;
            sum+=count(s);
        }
        return sum;
    }
    public int count(String s){
        int c=0;
        for(int i=1;i<s.length()-1;i++){
            char ch1=s.charAt(i-1);
            char ch2=s.charAt(i);
            char ch3=s.charAt(i+1);
            if((ch2>ch1 && ch2>ch3)||(ch2<ch1 && ch2<ch3))
                c++;
        }
        return c;
    }
}
