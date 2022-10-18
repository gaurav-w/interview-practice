package maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateAllMapCombinations {

	/*
	 * We need to generate a map say Map<Color,Direction>
	 * 
	 * There are 8 colors and 4 directions.
	 * 
	 * So each color can take 1 direction at a time. 4 ^ 8 = 65,536 combinations
	 * would be there for one map instance.
	 */
	public static void generateAllMaps(Map<Integer, Integer> baseMap, List<Map<Integer, Integer>> result, int color) {

		if (color == 8) {
			result.add(baseMap);
			System.out.println(Arrays.asList(baseMap));
			return;
		}

		for (int direction = 0; direction < 4; direction++) {
			HashMap<Integer, Integer> newMap = new HashMap<>(baseMap);
			newMap.put(color, direction);
			generateAllMaps(newMap, result, color + 1);
		}

	}

	public static void generateAllMaps2(List<Map<Integer, Integer>> result) {
		for (int i = 0; i <= 65535; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			int dir = i;
			for (int color = 0; color < 8; color++) {
				map.put(color, dir % 4);
				dir = dir / 4;
			}
			result.add(map);
		}
	}

	public static void main(String[] args) {
		// Color, Direction
		Map<Integer, Integer> baseMap = new HashMap<Integer, Integer>();
		baseMap.put(0, 0);
		baseMap.put(1, 0);
		baseMap.put(2, 0);
		baseMap.put(3, 0);
		baseMap.put(4, 0);
		baseMap.put(5, 0);
		baseMap.put(6, 0);
		baseMap.put(7, 0);

		List<Map<Integer, Integer>> result = new ArrayList<Map<Integer, Integer>>();

		generateAllMaps(baseMap, result, 0);
		// generateAllMaps2(result);

		System.out.println(result.size());

	}
}
