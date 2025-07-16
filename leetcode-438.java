class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] pFreq = new int[26];
        int[] sWindowFreq = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
            sWindowFreq[s.charAt(i) - 'a']++;
        }

        if (areFrequencyMapsEqual(pFreq, sWindowFreq)) {
            result.add(0);
        }

        for (int right = p.length(); right < s.length(); right++) {
            int left = right - p.length();

            sWindowFreq[s.charAt(left) - 'a']--;
            sWindowFreq[s.charAt(right) - 'a']++;

            if (areFrequencyMapsEqual(pFreq, sWindowFreq)) {
                result.add(left + 1);
            }
        }

        return result;
    }

    private boolean areFrequencyMapsEqual(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
}
