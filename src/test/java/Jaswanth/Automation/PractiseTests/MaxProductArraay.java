package Jaswanth.Automation.PractiseTests;

import java.util.Arrays;

public class MaxProductArraay 
{
	
	static void maxProduct(int arr[], int n)
    {
 
        // Sort the array
        Arrays.sort(arr);
        int num1, num2;
       
          // Calculate product of two smallest numbers
        int sum1 = arr[0] * arr[1];
       
          // Calculate product of two largest numbers
        int sum2 = arr[n - 1] * arr[n - 2];
       
          // print the pairs whose product is greater
        if (sum1 > sum2) {
            num1 = arr[0];
            num2 = arr[1];
        }
        else {
            num1 = arr[n - 2];
            num2 = arr[n - 1];
        }
        System.out.println("Max product pair = " +
                           "{" + num1 + "," + num2 + "}");
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = { 1, 4, 3, 6, 7, 0 };
        int n = arr.length;
        maxProduct(arr, n);
    }

}
