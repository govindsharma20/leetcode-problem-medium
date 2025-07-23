class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int writeIndex = 0;
        int i = 0;

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            int j = i;
            while (j < chars.length && chars[j] == currentChar) {
                count++;
                j++;
            }

            chars[writeIndex++] = currentChar;

            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char digitChar : countStr.toCharArray()) {
                    chars[writeIndex++] = digitChar;
                }
            }

            i = j;
        }

        return writeIndex;
    }
}
