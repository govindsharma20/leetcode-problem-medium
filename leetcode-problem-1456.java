class Solution {
    public int maxVowels(String s, int k) {
        int cv = 0;
        int mv = 0;

        for(int i=0;i<k;i++){
            if(isVowels(s.charAt(i))){
                cv++;
            }
        }
        mv = cv;

        for(int i=k;i<s.length();i++){
            if(isVowels(s.charAt(i-k))){
                cv--;
            }
            if(isVowels(s.charAt(i))){
                cv++;
            }
            mv = Math.max(mv,cv);
        }
        return mv;

    }
    private boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
