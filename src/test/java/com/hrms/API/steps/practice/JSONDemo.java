package com.hrms.API.steps.practice;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.hrms.utils.CommonMethods;

import io.restassured.path.json.JsonPath;

public class JSONDemo {
	
	public static void main(String[] args) {
		String storeText = CommonMethods.readJson("example.json");
		//System.out.println(storeText);
		
		//1st way
		JsonPath j = new JsonPath(storeText);
//		j.prettify();  //  will not print
//		j.prettyPrint(); // will print
		
		String books = j.getString("store.book");
		System.out.println(books);
		
		String secondBook = j.getString("store.book[1]");
		System.out.println("Second book as String --> " +secondBook);
		
		Object secondBookObject = j.get("store.book[1]");
		System.out.println("Second book as Object --> " +secondBookObject);
		
		Map<String, Object> castedMap = (Map<String, Object>) secondBookObject;
		System.out.println("Second book as map --> " + castedMap);
		
		String title = j.get("store.book[2].title");
		System.out.println(title);
		
		float price = j.get("store.book[2].price");
		System.out.println("Price of second book " + price);
		
		List<String> titleList = j.get("store.book.title");
		System.out.println("All titles --> " +titleList);
		int size = j.get("store.book.size()");
		System.out.println("How many books ? " +size);
		
		j.setRootPath("store.book[3]");
		String forthBookTitle = j.get("title");
		System.out.println("Forth book title --> " +forthBookTitle);
		System.out.println("===========================");
		
		JSONObject jObject = new JSONObject(storeText);
		JSONObject store = jObject.getJSONObject("store");
		JSONObject bicycle = jObject.getJSONObject("bicycle");
		System.out.println("BICYCLE --> " +bicycle);
		JSONArray bookList = store.getJSONArray("book");
		System.out.println("bookList --> " + bookList);
		
		//2.a
		JSONObject book = (JSONObject) bookList.getJSONObject(2);
		System.out.println("BOOK --> " + book);
		
	}
}
