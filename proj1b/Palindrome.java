public class Palindrome extends ArrayDeque<Character>{
    /*Given a String, wordToDeque should return a Deque where the characters appear in the same order as in the String.
    * For example, if the word is “persiflage”, then the returned Deque should have ‘p’ at the front, followed by ‘e’,
    * and so forth*/
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> palindrome_array = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            palindrome_array.addLast(word.charAt(i));
        }
        return palindrome_array;
    }

    public boolean isPalindrome(String word) {
        Deque d = wordToDeque(word);
        if (d.size() <= 1) {
            return true;
        } else {
            int index_back = d.size() - 1;
            for (int i = 0; i < d.size(); i++) {
                if (d.get(i) == d.get(index_back)) {
                    index_back--;
                } else {
                    return false;
                }
            }
            return true;
        }

    }
}
