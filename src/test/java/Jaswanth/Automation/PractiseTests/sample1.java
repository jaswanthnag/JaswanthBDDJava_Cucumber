package Jaswanth.Automation.PractiseTests;

public class sample1 {
	public static void main(String args[]) {
		int arr[]= {1,0,2,3};int count=0;		
		for(int i=0;i<=arr.length-1;i++) 
			if (arr[i]!=0) 
			arr[count++] = arr[i];
			  while (count < arr.length-1)

		            arr[count++] = 0;

			
			
		for (int j=0;j<=arr.length-1;j++) {
			 System.out.print(arr[j]+" ");
		}
			
			
		}
		
		
	}


