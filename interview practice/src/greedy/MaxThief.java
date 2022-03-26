package greedy;

import java.util.ArrayList;

public class MaxThief {
	public static int policeThief(char[] arr, int k) {
		int result = 0;
		ArrayList<Integer> thieves = new ArrayList<Integer>();
		ArrayList<Integer> police = new ArrayList<Integer>();
		int n = arr.length;
		// store indices in the respective vector
		for (int i = 0; i < n; i++) {
			if (arr[i] == 'P') {
				police.add(i);
			} else if (arr[i] == 'T') {
				thieves.add(i);
			}
		}
		int trackThieves = 0, trackPolice = 0;
		while (trackThieves < thieves.size() && trackPolice < police.size()) {
			// thieves can be caught
			if (Math.abs(thieves.get(trackThieves) - police.get(trackPolice)) <= k) {
				result++;
				trackThieves++;
				trackPolice++;
			}
			// increment the minimum index
			else if (thieves.get(trackThieves) < police.get(trackPolice)) {
				trackThieves++;
			} else {
				trackPolice++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int k, n;

		char policeTheifArray[] = { 'P', 'T', 'T', 'P', 'T' };
		k = 2;

		System.out.println("Maximum thieves caught for {P, T, T, P, T}: " + MaxThief.policeThief(policeTheifArray, k));

		char policeTheifArray1[] = { 'T', 'T', 'P', 'P', 'T', 'P' };
		k = 3;

		System.out
				.println("Maximum thieves caught for {T, T, P, P, T, P}: " + MaxThief.policeThief(policeTheifArray1, k));

	}
}