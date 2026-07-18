class Solution {
    public String mergeAlternately(String word1, String word2) {
        int left = 0, right = 0 ;

        StringBuilder result = new StringBuilder(word1.length() + word2.length());

        while (left < word1.length() && right < word2.length()) {
            result.append(word1.charAt(left++));
            result.append(word2.charAt(right++));
        }
        while (left < word1.length()  ) {
            result.append(word1.toCharArray()[left++]);
        }
        while (right < word2.length()) {
            result.append(word2.toCharArray()[right++]);
        }
        return result.toString();
    }
}