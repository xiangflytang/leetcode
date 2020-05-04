package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AddAndSearchWord {

}

class WordDictionary {
	Map<Integer, HashSet<String>> dict;

	/** Initialize your data structure here. */
	public WordDictionary() {
		dict = new HashMap<>();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		int length = word.length();
		if (dict.containsKey(length)) {
			HashSet<String> wordInLength = dict.get(length);
			wordInLength.add(word);
		} else {
			HashSet<String> wordInLength = new HashSet<>();
			wordInLength.add(word);
			dict.put(length, wordInLength);
		}
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		int length = word.length();
		HashSet<String> wordInLength = dict.getOrDefault(length, new HashSet<>());
		if (wordInLength.contains(word)) {
			return true;
		}
		for (String s : wordInLength) {
			if (equals(s, word)) {
				return true;
			}
		}
		return false;
	}

	private boolean equals(String strToMatch, String word) {
		char[] src = strToMatch.toCharArray();
		char[] target = word.toCharArray();
		for (int i = 0; i < src.length; i++) {
			if ((src[i] != target[i]) && (src[i] != '.')) {
				return false;
			}
		}
		return true;
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */