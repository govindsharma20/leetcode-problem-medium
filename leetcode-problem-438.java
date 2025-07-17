import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int pLen = p.length();
        int sLen = s.length();

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        for (int i = 0; i < pLen; i++) {
            pFreq[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < pLen; i++) {
            windowFreq[s.charAt(i) - 'a']++;
        }

        boolean isAnagram = true;
        for (int i = 0; i < 26; i++) {
            if (pFreq[i] != windowFreq[i]) {
                isAnagram = false;
                break;
            }
        }
        if (isAnagram) {
            result.add(0);
        }

        for (int i = pLen; i < sLen; i++) {
            windowFreq[s.charAt(i) - 'a']++;
            windowFreq[s.charAt(i - pLen) - 'a']--;

            isAnagram = true;
            for (int j = 0; j < 26; j++) {
                if (pFreq[j] != windowFreq[j]) {
                    isAnagram = false;
                    break;
                }
            }
            if (isAnagram) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }
}
