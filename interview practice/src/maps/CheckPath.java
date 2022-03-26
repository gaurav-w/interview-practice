package maps;

import java.util.HashMap;
import java.util.Map;

//Hash Set  =>  HashSet<Integer> hSet = new HashSet<>();
//HashMap   =>  HashMap<Integer,String> hMap = new HashMap<>();  
//HashTable =>  Hashtable<Integer,String> hTable = new Hashtable<>();  
//Hash Set Functions => {add(), remove(), contains()}
//Hash Map and Table Functions => {put(key,value), get(key), remove(key), containsKey(key), containsValue(value)}
class CheckPath {

	public static String tracePath(Map<String, String> map) {

		HashMap<String, String> reverseMap = new HashMap<>();

		String result = "";
		String startingCity = "";

		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();

			reverseMap.put(value, key);

		}

		for (Map.Entry<String, String> entry : reverseMap.entrySet()) {

			String key = entry.getKey();
			String value = entry.getValue();

			if (reverseMap.get(value) == null) {
				startingCity = value;
				break;
			}

		}

		while (startingCity != null) {

			String key = startingCity;
			String value = map.get(startingCity);

			if (value == null)
				break;
			else {
				result = result + key + "->" + value + ",";
				startingCity = value;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		HashMap<String, String> hMap = new HashMap<>();

		hMap.put("NewYork", "Chicago");
		hMap.put("Boston", "Texas");
		hMap.put("Missouri", "NewYork");
		hMap.put("Texas", "Missouri");

		String actual_output = CheckPath.tracePath(hMap);

		System.out.println(actual_output);
	}
}
