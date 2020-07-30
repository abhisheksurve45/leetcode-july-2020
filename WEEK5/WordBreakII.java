public class WordBreakII {

    class Solution {

        public List<String> wordBreak(String s, List<String> wordDict) {
            return wordBreakHelper(s, wordDict, new HashMap<String, List<String>>());
        }

        private List<String> wordBreakHelper(String s, List<String> wordDict, Map<String, List<String>> map) {

            if (map.containsKey(s)) return map.get(s);

            List<String> result = new ArrayList<>();

            if (s != null && s.isEmpty()) {
                result.add("");
                return result;
            }

            for (String word : wordDict) {

                if (s.startsWith(word)) {

                    List<String> subList = wordBreakHelper(s.substring(word.length()), wordDict, map);

                    for (String sub : subList) {
                        sub = sub.isEmpty() ? sub : " " + sub;
                        result.add(word + sub);
                    }

                }

            }

            map.put(s, result);
            return result;
        }
    }
}
