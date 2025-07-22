class Solution {
    public String reverseWords(String s) {
        if(s == null || s.isEmpty()){
            return "";
        }

        StringBuilder result = new StringBuilder();
        int n = s.length();
        int i = n-1;

        while(i >= 0){
            while(i>=0 && s.charAt(i) == ' '){
                i--;
            }
            if(i < 0){
                break;
            }
            int wordEnd = i;
            while(i >=0 && s.charAt(i) != ' '){
                i--;
            }
            int wordStart = i+1;
            String word = s.substring(wordStart, wordEnd + 1);

            if(result.length() > 0){
                result.append(" ");
            }
            result.append(word);
        }
        return result.toString(); 
    }
}
