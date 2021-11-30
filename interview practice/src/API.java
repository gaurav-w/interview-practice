import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.net.URL;
import java.net.*;
import com.google.gson.JsonObject;
import com.google.gson.*;

class Response {
	String name;
	Float average_rating;

	Response(String a, Float b) {
		this.name = a;
		this.average_rating = b;
	}
}

class Result {

	/*
	 * Complete the 'getTopRatedFoodOutlets' function below.
	 *
	 * URL for cut and paste
	 * https://jsonmock.hackerrank.com/api/food_outlets?city=<city>&page=<
	 * pageNumber>
	 *
	 * The function is expected to return an array of strings.
	 * 
	 * The function accepts only city argument (String).
	 */

	public static List<String> getTopRatedFoodOutlets(String city) {
		int currentPage = 1;
		int endPage = Integer.MAX_VALUE;
		String response = null;
		List<Response> responses = new ArrayList<Response>();
		List<String> titles = new ArrayList<String>();
		try {

			while (currentPage <= endPage) {
				URL url = new URL(
						"https://jsonmock.hackerrank.com/api/food_outlets?city=" + city + "&page=" + currentPage);
				// System.out.println("https://jsonmock.hackerrank.com/api/food_outlets?city="+city+"&page="+currentPage);

				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

				while ((response = in.readLine()) != null) {
					JsonObject convertedObject = new Gson().fromJson(response, JsonObject.class);
					endPage = convertedObject.get("total_pages").getAsInt();

					JsonArray data = convertedObject.getAsJsonArray("data");
					for (int i = 0; i < data.size(); i++) {
						String title = data.get(i).getAsJsonObject().get("name").getAsString();
						Float rating = Float.valueOf(data.get(i).getAsJsonObject().get("user_rating").getAsJsonObject()
								.get("average_rating").getAsString());
						// if(title.contains("Palladium ") ){
						// System.out.println(title);
						// System.out.println(rating);
						// }
						responses.add(new Response(title, rating));
					}

				}

				in.close();
				currentPage++;

			}
		} catch (Exception e) {

		}

		Collections.sort(responses, (a, b) -> Float.compare(b.average_rating, a.average_rating));

		float rating = responses.get(0).average_rating;
		for (int i = 0; i < responses.size(); i++) {
			if (rating == responses.get(i).average_rating)
				titles.add(responses.get(i).name);
		}

		return titles;
	}

}


///*
//Enter your query here.
//Please append a semicolon ";" at the end of the query
//*/
//
//select score from student order by score desc limit 212,1;

//activiate fountain

public class Solution {