package Jaswanth.Automation.PractiseTests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class checkUniqueElementFrequencyStatus 
{
	
	static boolean checkUniqueFrequency(int arr[],
		    int n) {

		    // Freq map will store the frequency
		    // of each element of the array
		    HashMap < Integer,
		        Integer > freq = new HashMap < Integer,
		        Integer > ();

		    // Store the frequency of each
		    // element from the array
		    for (int i = 0; i < n; i++) {
		        if (freq.containsKey(arr[i])) {
		            freq.put(arr[i], freq.get(arr[i]) + 1);
		        } else {
		            freq.put(arr[i], 1);
		        }
		    }

		    HashSet < Integer > uniqueFreq = new HashSet < Integer > ();

		    // Check whether frequency of any
		    // two or more elements are same
		    // or not. If yes, return false
		    for (Map.Entry < Integer,
		        Integer > i: freq.entrySet()) {
		        if (uniqueFreq.contains(i.getValue()))
		            return false;
		        else
		            uniqueFreq.add(i.getValue());
		    }

		    // Return true if each
		    // frequency is unique
		    return true;
		}

		// Driver Code
		public static void main(String[] args) {

		    // Given array arr[]
		    int arr[] = {
		        1,
		        1,
		        2,
		        5,
		        5
		    };
		    int n = arr.length;

		    // Function call
		    boolean res = checkUniqueFrequency(arr, n);

		    // Print the result
		    if (res)
		        System.out.print("Yes" + res);
		    else
		        System.out.print("No" + res);
		}
		}


