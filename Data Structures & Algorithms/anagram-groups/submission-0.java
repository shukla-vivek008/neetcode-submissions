class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> mpp = new HashMap<>();
        
        for(String s : strs) {
            int freq[] = new int[26];
            for(char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();

            for(int f : freq) {
                sb.append("#");
                sb.append(f);
            }
            String key = sb.toString();
            if(!mpp.containsKey(key)) {
                mpp.put(key, new ArrayList<String>());
            }
            mpp.get(key).add(s);
        }

        return new ArrayList(mpp.values());
    }
}
