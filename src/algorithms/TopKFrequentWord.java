package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWord {

}

class Solution {
	private Map<String, Integer> wordAndCount = new HashMap<>();

	public List<String> topKFrequent(String[] words, int k) {
		for (String word : words) {
			wordAndCount.put(word, wordAndCount.getOrDefault(word, 0) + 1);
		}
		List<String> candidates = new ArrayList<>(wordAndCount.keySet());
		candidates.sort((String w1, String w2) -> (wordAndCount.get(w1).equals(wordAndCount.get(w2)) ? w1.compareTo(w2)
				: wordAndCount.get(w2).compareTo(wordAndCount.get(w1))));
		List<String> topK = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			topK.add(candidates.get(i));
		}
		Integer integer;
		return topK;
	}
}
