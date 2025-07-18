class Solution {
    public int characterReplacement(String s, int k) {
        int[] charCounts = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            charCounts[currentChar - 'A']++;
            
            maxFreq = Math.max(maxFreq, charCounts[currentChar - 'A']);

            int windowLength = right - left + 1;

            if (windowLength - maxFreq > k) {
                char charLeavingWindow = s.charAt(left);
                charCounts[charLeavingWindow - 'A']--;
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
