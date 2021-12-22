package topoligcalsort;

import java.util.*;

class AlienDictionary {

	public static String findOrder(String[] words) {

		HashMap<Character, ArrayList<Character>> graph = new HashMap<Character, ArrayList<Character>>();
		HashMap<Character, Integer> indegree = new HashMap<>();
		Queue<Character> queue = new LinkedList<>();
		StringBuffer sb = new StringBuffer();

		for (String word : words) {
			for (char character : word.toCharArray()) {
				indegree.put(character, 0);
				graph.put(character, new ArrayList<Character>());
			}
		}

		for (int i = 1; i < words.length; i++) {
			String word1 = words[i - 1];
			String word2 = words[i];

			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					// result.getOrDefault(word1.charAt(j), new ArrayList<Character>());
					ArrayList<Character> list = graph.get(word1.charAt(j));
					if (list == null)
						list = new ArrayList<Character>();

					list.add(word2.charAt(j));
					graph.put(word1.charAt(j), list);

					indegree.put(word2.charAt(j), indegree.getOrDefault(word2.charAt(j), 0) + 1);
					break;
				}
			}
		}

		for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
			if (entry.getValue() == 0)
				queue.add(entry.getKey());
		}

		while (!queue.isEmpty()) {
			Character pop = queue.remove();
			sb.append(pop);

			ArrayList<Character> children = graph.get(pop);

			for (Character child : children) {
				indegree.put(child, indegree.get(child) - 1);

				if (indegree.get(child) == 0)
					queue.add(child);
			}

		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
		System.out.println("Character order: " + result);

		result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
		System.out.println("Character order: " + result);

		result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
		System.out.println("Character order: " + result);
	}
}
