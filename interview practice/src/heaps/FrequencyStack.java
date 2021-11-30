package heaps;

import java.util.*;
import java.util.Map.Entry;

class FrequencyStack {
	PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue((a, b) -> ((Entry<Integer, Integer>) b).getValue() - ((Entry<Integer, Integer>) a).getValue());
	Map<Integer, Integer> freqMap = new HashMap<>();

	public void push(int num) {
		freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
	}

	public int pop() {
		pq.clear();
		pq.addAll(freqMap.entrySet());

		Map.Entry<Integer, Integer> element = pq.remove();
		if (freqMap.get(element.getKey()) == 0)
			freqMap.remove(element.getKey());
		else
			freqMap.put(element.getKey(), freqMap.get(element.getKey()) - 1);

		return element.getKey();
	}

	public static void main(String[] args) {
		FrequencyStack frequencyStack = new FrequencyStack();
		frequencyStack.push(1);
		frequencyStack.push(2);
		frequencyStack.push(3);
		frequencyStack.push(2);
		frequencyStack.push(1);
		frequencyStack.push(2);
		frequencyStack.push(5);
		System.out.println(frequencyStack.pop());
		System.out.println(frequencyStack.pop());
		System.out.println(frequencyStack.pop());
	}
}
