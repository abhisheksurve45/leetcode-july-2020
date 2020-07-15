public class ReverseWordsinString {
    class Solution {
        public String reverseWords(String s) {
            class Solution {
                public String reverseWords(String s) {
                    String[] words = s.trim().split("\\s+");
                    Collections.reverse(Arrays.asList(words));
                    return String.join(" ", words);
                }
            }
        }
    }
}
