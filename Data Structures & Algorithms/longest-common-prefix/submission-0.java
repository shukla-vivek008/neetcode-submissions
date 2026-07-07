class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        StringBuilder pre = new StringBuilder();

        int minLen = strs[0].length();
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }

        for (int i = 0; i < minLen; i++) {
            char ch = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != ch) {
                    return pre.toString();
                }
            }
            pre.append(ch);
        }

        return pre.toString();
    }
}