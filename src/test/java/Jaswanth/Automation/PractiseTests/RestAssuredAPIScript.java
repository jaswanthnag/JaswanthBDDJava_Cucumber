package Jaswanth.Automation.PractiseTests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredAPIScript 
{

	
	public static void main(String[] args) {
        String userID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
        String userName = "TOOLSQA-Test";
        String password = "Test@@123";
        String baseUrl = "https://bookstore.toolsqa.com";
        Response response;
        String jsonString;
        String token = null;

        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();


        //Step - 1
        //Test will start from generating Token for Authorization
		
		
		  request.header("Content-Type", "application/json");
		  
		  response = request.body("{ \"userName\":\"" + userName +
		  "\", \"password\":\"" + password + "\"}") .post("/Account/v1/GenerateToken");
		  
		  Assert.assertEquals(response.getStatusCode(), 200);
		  
		  jsonString = response.asString();
		  Assert.assertTrue(jsonString.contains("token"));
		  System.out.println("Access Token" + JsonPath.from(jsonString).get("token"));
		  
		  //This token will be used in later requests String token = token =
		  JsonPath.from(jsonString).get("token");
		 
		 


        //Step - 2
        // Get Books - No Auth is required for this.
        response = request.get("/BookStore/v1/Books");// https://bookstore.toolsqa.com//BookStore/v1/Books
        System.out.println("Get Status Code: " + response.getStatusCode());

        Assert.assertEquals(response.getStatusCode(), 200);

        
        jsonString = response.asString();
        List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
        Assert.assertTrue(books.size() > 0);

         //This bookId will be used in later requests, to add the book with respective isbn
        String bookId = books.get(0).get("isbn");


        //Step - 3
        // Add a book - with Auth
        //The token we had saved in the variable before from response in Step 1, 
        //we will be passing in the headers for each of the succeeding request
		
		
		  request.header("Authorization", "Bearer " + token) .header("Content-Type",
		  "application/json");
		  
		  response = request.body("{ \"userId\": \"" + userID + "\", " +
		  "\"collectionOfIsbns\": [ { \"isbn\": \"" + bookId + "\" } ]}")
		  .post("/BookStore/v1/Books");
		  
		  System.out.println("Post Status Code: " + response.getStatusCode());
		  Assert.assertEquals( 201, response.getStatusCode());
		 
		 


        //Step - 4
        // Delete a book - with Auth
		/*
		 * request.header("Authorization", "Bearer " + token) .header("Content-Type",
		 * "application/json");
		 * 
		 * response = request.body("{ \"isbn\": \"" + bookId + "\", \"userId\": \"" +
		 * userID + "\"}") .delete("/BookStore/v1/Book");
		 * 
		 * Assert.assertEquals(204, response.getStatusCode());
		 */

        //Step - 5
        // Get User
		/*
		 * request.header("Authorization", "Bearer " + token) .header("Content-Type",
		 * "application/json");
		 * 
		 * response = request.get("/Account/v1/User/" + userID);
		 * Assert.assertEquals(200, response.getStatusCode());
		 * 
		 * jsonString = response.asString(); List<Map<String, String>> booksOfUser =
		 * JsonPath.from(jsonString).get("books"); Assert.assertEquals(0,
		 * booksOfUser.size());
		 */
    }


}
