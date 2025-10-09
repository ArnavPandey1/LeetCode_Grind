class Solution {
    public boolean winnerOfGame(String colors) {
        int amoves=0;
        int bmoves=0;
        for(int i=1;i<colors.length()-1;i++){
            if(colors.charAt(i-1)==colors.charAt(i)&&colors.charAt(i)==colors.charAt(i+1)){
                if(colors.charAt(i)=='A')
                amoves++;
                else
                bmoves++;
            }
        }
        if(amoves>bmoves)
        return true;
        else
        return false;
    }
}